package com.example.validate;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * <p> write your description here
 *
 * @author 【千殇】（【罗玉华】qianshang.luo@tuya.com）
 * @since 2022/3/30 2:52 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ValidateApplication.class)
public class BaseTest {


    @Resource
    ApplicationContext applicationContext;
    @Resource
    protected AutowireCapableBeanFactory spring;

    protected <T> T autowireEntity(T t) {
        spring.autowireBean(t);
        return t;
    }

    public void setSpring(AutowireCapableBeanFactory spring) {
        this.spring = spring;
    }

    /**
     * debug 任意方法
     * 输入方法名进行测试
     * 例：test1
     * 例：com.tuya.diting.repository.EvaluateRepositoryTest#add
     * 输入"q" (quit)  退出程序
     * 输入"all" 执行当前测试类所有 public 方法
     * 修改代码重新构建后新代码生效
     * <p>
     * 修改 idea.vmoptions 追加 -Deditable.java.test.console=true 以启用调试输入
     */
    @Before
    public void 通用测试() throws InvocationTargetException, IllegalAccessException {
        Object env = System.getProperties().get(("env"));
        if (!Objects.equals(env, "dev")) {
            return;
        }
        System.out.println("==========开始测试: " + LocalDateTime.now());
        boolean quit = false;
        while (!quit) {
            Map<String, String> result = new HashMap<>();
            System.out.println("\33[30m输入要测试的方法(例:test1), q(quit) 退出\033[30m\n\r");
            Scanner in = new Scanner(System.in);
            String inputMethod = in.nextLine().trim();
            if (StringUtils.isBlank(inputMethod)) {
                continue;
            }
            long start = System.currentTimeMillis();
            if ("q".equalsIgnoreCase(inputMethod)) {
                quit = true;
                continue;
            } else if (inputMethod.contains(".")) {
                // 指定 service 调用
                result.putAll(generalInvoke(inputMethod));
            } else {
                //当前测试类方法调用
                result.putAll(currentInvoke(inputMethod));
            }
            long cost = System.currentTimeMillis() - start;
            System.out.println("\u001b[1;36;43m--------------测试结果 cost：" + cost + "--------------\033[30m");
            result.entrySet().forEach(o -> System.out.println(o.getKey() + ": " + o.getValue()));
            System.out.println("\u001b[1;36;43m--------------测试结果 cost：" + cost + "--------------\033[30m");
        }
        System.out.println("\33[31;1m正在退出。。。\033[30m");
        System.exit(0);
    }

    /**
     * 通用本地测试方法
     * invokeService ：需要调用的 service
     * method : 调用方法
     * args ： 参数（数组）
     * 示例
     * com.tuya.diting.service.business.eba.DeviceConfigServiceTest#addDeviceConfig()
     *
     * @param
     * @return
     */
    private Object invoke(String input) throws InvocationTargetException, IllegalAccessException {
        String[] inputArg;
        if (input.contains("#")) {
            inputArg = input.split("#");
        } else {
            inputArg = input.split("\\.");
        }
        String invokeServiceName = inputArg[0];
        String[] methodAndArg = inputArg[1].split("\\(");

        String method = methodAndArg[0];
        String parameter = "";
        if (methodAndArg.length > 1) {
            parameter = methodAndArg[1].substring(0, methodAndArg[1].length() - 1);
        }
        parameter = "[" + parameter + "]";
        Object[] args = JSON.parseArray(parameter).toArray();

        Object invokeService;
        try {
            invokeService = applicationContext.getBean(invokeServiceName);
        } catch (Exception e) {
            try {
                invokeService = Class.forName(invokeServiceName).newInstance();
                autowireEntity(invokeService);
            } catch (ClassNotFoundException ex) {
                throw e;
            } catch (InstantiationException ex) {
                throw e;
            }
        }

        Method[] declaredMethods = invokeService.getClass().getDeclaredMethods();
        for (Method method1 : declaredMethods) {
            if (!method1.getName().equals(method) || args.length != method1.getParameterTypes().length) {
                continue;
            }
            Type[] genericParameterTypes = method1.getGenericParameterTypes();
            Class[] parameterTypes = method1.getParameterTypes();
            boolean methodMatch = buildArgs(args, genericParameterTypes, parameterTypes);
            if (!methodMatch) {
                return "\33[31;1m参数转换失败\033[30m";
            }
            Object invokeResult = method1.invoke(invokeService, args);
            System.out.println("invokeResult：" + JSON.toJSONString(invokeResult));
            return "\33[36;1m成功\033[30m";
        }
        return "\33[31;1m方法未找到\033[30m";
    }

    private boolean checkAnnotations(Method method) {
        List<Annotation> annotations = java.util.Arrays.asList(method.getDeclaredAnnotations());
        List<Class> testAnnotations = Arrays.asList(Before.class, Test.class, After.class);

        for (Annotation o : annotations) {
            if (testAnnotations.contains(o.annotationType())) {
                return true;
            }
        }
        return false;
    }

    private Map<String, String> currentInvoke(String inputMethod) {
        Map<String, String> result = new HashMap<>();
        Method[] declaredMethods = this.getClass().getDeclaredMethods();
        for (Method method : declaredMethods) {
            if ("通用测试".equals(method.getName())) {
                continue;
            }
            if (!method.getName().equals(inputMethod) && !"all".equalsIgnoreCase(inputMethod)) {
                continue;
            }
            if (!checkAnnotations(method)) {
                continue;
            }
            String msg = "\33[36;1m成功\033[30m";
            try {
                method.invoke(this, new Object[] {});
            } catch (Exception e) {
                msg = "\33[31;1m失败\033[30m";
                e.printStackTrace();
            }
            result.put(method.getName(), msg);

        }
        if (result.isEmpty()) {
            result.put(inputMethod, "\33[31;1m方法未找到\033[30m");
        }
        return result;
    }

    private Map<String, String> generalInvoke(String inputMethod) {
        Map<String, String> result = new HashMap<>();
        String invokeMethod = inputMethod.split("\\(")[0];
        try {
            result.put(invokeMethod + "", this.invoke(inputMethod).toString());
        } catch (Exception e) {
            e.printStackTrace();
            result.put("\33[31;1m" + invokeMethod, JSON.toJSONString(e.getMessage()));
        }
        return result;
    }

    /**
     * @param args
     * @param genericParameterTypes
     * @param parameterTypes
     * @return
     */
    private boolean buildArgs(Object[] args, Type[] genericParameterTypes, Class[] parameterTypes) {
        boolean methodMatch = true;
        for (int i = 0; i < genericParameterTypes.length; i++) {
            Class clazz;
            try {
                clazz = Class.forName(genericParameterTypes[i].getTypeName());
            } catch (ClassNotFoundException e) {
                clazz = parameterTypes[i];
            }
            Object arg = args[i];
            if (arg == null) {
                continue;
            }

            Constructor<?>[] constructors = clazz.getConstructors();
            boolean constructorMatch = false;
            for (Constructor constructor : constructors) {
                try {
                    Object obj = constructor.newInstance(arg);
                    arg = obj;
                    constructorMatch = true;
                    System.out.println("转换成功" + i + "：" + clazz.getName());
                    break;
                } catch (Exception e) {
                }
            }
            if (constructorMatch) {
                break;
            }
            if (arg instanceof java.util.LinkedHashMap || arg instanceof JSON) {
                System.out.println("Map转换" + i + "：" + clazz.getName());
                Object temp = JSON.parseObject(JSON.toJSONString(arg), clazz);
                if (arg != null && temp == null) {
                    break;
                }
                arg = temp;
            }
            if (!clazz.isInstance(arg)) {
                methodMatch = false;
            }
            args[i] = arg;
            System.out.println("转 换 为" + i + "：" + arg.getClass().getName());
            System.out.println("方法参数" + i + "：" + clazz.getName());
            System.out.println("----------------------------");
        }
        return methodMatch;
    }

}

