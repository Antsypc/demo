package xyz.antsgroup.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.antsgroup.demo.spring.entity.Manager;

import javax.servlet.http.HttpServletRequest;
import java.io.Writer;
import java.util.List;
import java.util.Map;

/**
 * @author ants_ypc
 * @version 1.0 6/1/16
 */
@Controller
@RequestMapping(path = "/example/pa/")
public class HelloController {

    /**
     * 1. 请求 URI 为 /example/pa/hello 执行该方法
     * 2. 如果类没有 @RequestMapping 注解,该类所有方法的 URI 都为绝对路径
     * 3. 虽然父指定了GET请求,但该方法没有指定 @RequestMapping 的 method,
     *    所有 HTTP 请求方法都可以访问 /example/pa/hello
     * 4. Model 从 DispatcherServlet 传来,给他设置参数就如同向 RequestServlet setAttribute
     *
     * eg: http://localhost:8080/course/example/pa/hello
     */
    @RequestMapping("hello")
    public String hello(Model model) {
        model.addAttribute("msg", "This is Spring MVC Hello World.");
        System.out.println("This is Spring MVC Hello World.");
        return "hello";   // 服务端内部跳转当该页面
        //        return "redirect:/login";         // 客户端重定向写法,在重定向时会加上当前 web app 的 contextPath
    }

    /**
     * 1. @ResponseBody 代表返回值即请求输出值,也可用 Writer 参数.如果返回的是对象,将自动转换成 JSON.
     * 2. @PathVariable 自动从 URI 获取并赋值给对应变量.如果 {userId} 与方法参数名不一致,
     *    可以 @PathVariable("paramName") 指定 URI 中的参数赋值给当前变量
     * 3. @RequestMapping path 参数支持正则表达式,多个匹配成功时采取最长匹配,最精确匹配原则.
     *    /* 中*表示匹配/以外的字符, /** 可以匹配包括/的字符.如findOwnerOne和findOwnerTwo
     *
     * eg: http://localhost:8080/course/example/pa/user/Antsypc/2011-11
     */
    @RequestMapping("/user/{userId}/{year:\\d{4}}-{month:\\d\\d}")
    @ResponseBody
    public String findOwner(@PathVariable String month, @PathVariable String year,
            @PathVariable String userId) {
        System.out.println(userId + year + month);
        return userId + year + month;
    }

    @RequestMapping("/user/{userId}/{year:\\d{4}}-{month:\\d\\d}/*")
    @ResponseBody
    public String findOwnerOne(@PathVariable String year, @PathVariable String userId,
            @PathVariable String month, Model model) {
        System.out.println("one card" + userId + year + month);
        return "one card" + userId + year + month;
    }

    @RequestMapping("/user/{userId}/{year:\\d{4}}-{month:\\d\\d}/**")
    @ResponseBody
    public String findOwnerTwo(@PathVariable String userId, @PathVariable String year,
            @PathVariable String month, Model model) {
        System.out.println("two card" + userId + year + month);
        return "two card" + userId + year + month;
    }


    /**
     * URI 参数使用 Matrix Variable.
     * 需要在 dispatcher-servlet.xml 中添加 `<mvc:annotation-driven enable-matrix-variables="true"/>`
     *
     * eg: http://localhost:8080/course/example/pa/user/Antsypc;p=123/identity/2016;q=3
     */
    @RequestMapping("/user/{userId}/identity/{date}")
    @ResponseBody
    public String findOwnerThree(@PathVariable String userId, @PathVariable String date,
            @MatrixVariable(name="p", pathVar = "userId") String p,
            @MatrixVariable(name="q", pathVar="date", required = false, defaultValue = "1") int q) {
        System.out.println("userId=" + userId + ",date=" + date + ",p=" + p + ",q=" + q);
        // userId=Antsypc,date=2016,p=123,q=3
        return "userId=" + userId + ",date=" + date + ",p=" + p + ",q=" + q;
    }

    /**
     * eg: http://localhost:8080/course/example/pa/user/Antsypc;p=123;q=11/i/2016;q=3;r=1
     */
    @RequestMapping("/user/{userId}/i/{date}")
    @ResponseBody
    public String findOwnerFour(@MatrixVariable Map<String, List<String>> a,
            @MatrixVariable(pathVar = "date") Map<String, List<String>> b)  {
        String res = "";
        for (Map.Entry<String, List<String>> entry : a.entrySet()) {
            res = res + entry.getKey() + "=";
            for (String s : entry.getValue()) {
                res = res + s + ",";
            }
            res += ";";
        }
        System.out.println(res);
        // p=123,;q=11,3,;r=1,;
        return res;
    }

    /**
     * 指定 POST 的数据是 JSON 并自动映射到 Manager 对象,返回类型是 text/plain;charset=utf-8.
     * 测试在 /course/example/pa/hello
     *
     * consumes: 指定处理请求的提交内容类型(Content-Type),例如application/json, text/html;
     * produces: 指定返回的内容类型,仅当request请求头中的(Accept)类型中包含该指定类型才返回
     *
     * params: 指定request中必须包含某些参数值是,才让该方法处理.eg: params="myParam"
     * headers: 指定request中必须包含某些指定的header值,才能让该方法处理请求.
     */
    @RequestMapping(path = "/user/profile", method = RequestMethod.POST,
            consumes = "application/json", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String userProfile(@RequestBody Manager manager) {
        System.out.println(manager);
        return manager.toString();
    }

    /**
     * params: 指定request中必须包含某些参数值是,才让该方法处理.
     *         如下,必须同时满足有id,没有password,gender=nan
     * headers: 指定request中必须包含某些指定的header值,才能让该方法处理请求.
     *
     * 注意,同时满足 userProfileTwo 和 userProfileThree 时,会执行前者.
     */
    @RequestMapping(path = "/user/profile", method = RequestMethod.GET,
            params = {"id","!password","gender=nan"})
    @ResponseBody
    public String userProfileTwo(HttpServletRequest request) {
        String s="";
        for (Map.Entry entry : request.getParameterMap().entrySet()) {
            s = s + entry.getKey() + "=";
            for (String a : (String[])entry.getValue()) {
                s = s + a + ",";
            }
        }
        System.out.println(s);
        return s;
    }

    /**
     * 使用@RequestParam
     */
    @RequestMapping(path = "/user/profile", method = RequestMethod.GET)
    @ResponseBody
    public String userProfileThree(HttpServletRequest request,
            @RequestParam(value = "id", required = false) String id) {
        String s = "id=" + id + ";";
        for (Map.Entry entry : request.getParameterMap().entrySet()) {
            s = s + entry.getKey() + "=";
            for (String a : (String[]) entry.getValue()) {
                s = s + a + ",";
            }
        }
        System.out.println(s);
        return s;
    }

    /**
     * 使用@RequestBody, Writer 代替 @ResponseBody
     */
    @RequestMapping(path = "/user/profile/do", method = RequestMethod.POST)
    public void userProfileFour(@RequestBody String body, Writer writer) throws Exception{
        String s = "RequestBody=" + body + ";";
        System.out.println(s);
        writer.write(s);
    }

    /**
     * 在方法上使用@ModelAttribute,该方法会在当前类的所有方法执行前执行,
     * 给 Model 设置参数可能影响其他请求,要根据具体情况考虑.
     */
    @ModelAttribute
    public void modelDemo(Model model, Map<String,Object> map) {
        System.out.println("ModelAttribute modelDemo...");
        System.out.println("map hashcode: " + map.hashCode());
        System.out.println("model hashcode:" + model.hashCode());
        model.addAttribute("modelTest", "testvalue");
        map.put("key01", "value01");
    }
    @ModelAttribute("ma")   // 表示把 manager 对象加入 Model, 键名为 ma,如果不设置将默认为 manager.
    public Manager addManager(Model model, Map<String, Object> map) {
        System.out.println("ModelAttribute addManager...");
        System.out.println("map hashcode: " + map.hashCode());
        System.out.println("model hashcode:" + model.hashCode());
        Manager manager = new Manager();
        manager.setName("managerInModelAttribute");
        return manager;
    }
    @RequestMapping("/model/on/method")
    @ResponseBody
    public String modelDemo1(Model model) {
        String s = "";
        for (Map.Entry<String, Object> entry : model.asMap().entrySet()) {
            s = s + entry.getKey() + "=";
            s = s + entry.getValue() + ";";
        }
        System.out.println(s);
        // modelTest=testvalue;
        return s;
    }

    /**
     * 在方法参数上使用@ModelAttribute,表示该参数是从 Model 中获取的,
     * 如果没有将会从请求参数中(get,post 中的键值对)映射构造一个并放入 Model.如 modelDemo3,
     * 其他Map等并不会传递,如果需要返回到视图层,可以返回页面输出
     */
    @RequestMapping("/model/on/param")
    @ResponseBody
    public String modelDemo2(@ModelAttribute("ma") Manager manager, Map<String,Object> map, Model model) {
        System.out.println(manager);
        System.out.println("check modelAttribute map:" + map.get("value01"));
        System.out.println("check modelAttribute model:" + model.asMap().get("ma"));
        System.out.println("map hashcode: " + map.hashCode());
        System.out.println("model hashcode:" + model.hashCode());
        // Manager{id='null', password='null', name='managerInModelAttribute',
        // position='null', gender='null', phone='null', email='null'}
        return manager.toString();
    }
    @RequestMapping(path = "/user/profile", params = "id=ypc")
    @ResponseBody
    public String modelDemo3(@ModelAttribute Manager manager) {
        System.out.println(manager);
        // Manager{id='null', password='null', name='managerInModelAttribute',
        // position='null', gender='null', phone='null', email='null'}
        return manager.toString();
    }
}