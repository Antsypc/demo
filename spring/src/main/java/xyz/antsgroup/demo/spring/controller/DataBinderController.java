package xyz.antsgroup.demo.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.antsgroup.demo.spring.entity.Employee;
import xyz.antsgroup.demo.spring.entity.Manager;

/**
 *
 */
@Controller
@RequestMapping("/dataBinder")
public class DataBinderController {
    /*
    数据绑定
    - 基本类型与包装类型: 直接在 mapping 方法的入参传,也可以用 @RequestParam
    - 数组: 直接使用,URL 使用 name=a&name=b&name=c 方式
    - List: 不能直接把 List 作为参数放在 mapping 方法中, List 要作为另外一个对象A的成员变量,把A作为参数放在mapping方法中
            List<User> URL: userList[1].name=a&userList[2].name=b 如果跨界直接 userList[30],name=z 中间会有27个对象中的值为空
    - Set: 与 List 用法一样,只是需要提前初始化Set对象,不建议使用
    - Map: 同样不能直接作为方法参数传入,Map<User> URL: userMap['A'].name=a&userMap['B'].name=b&userMap['A'].age=10
    - json: 方法入参前加 @RequestBody
    - xml: 方法入参加 @RequestBody, 使用spring-oxm包, 映射对象使用 @XmlRootElement, @XmlElement 等注解
     */

    /*
    数据绑定执行顺序

    1. 自动创建一个隐含模型对象;
    2. 调用所有 @ModelAttribute 将值放入隐含模型对象;
    3. 查看 Session 是否有 @SessionAttribute("") 指定的属性,有则放入模型对象(覆盖之前的相同值);
    4. Mapping 方法入参使用 @ModelAttribute("xx") 并且xxx是类定义处@SessionAttribute("xx"), 该入参赋值过程:
       - 先从隐含模型找
       - 再从 @SessionAttribute 找
       - 否则报HttpSessionRequiredException
       - 解决办法: 使用@ModelAttribute 标注的方法,创建一个对象返回,以此放入隐含模型

     */

    // localhost:8080/dataBinder/basic/one?b=aa&a=bb
    // 根据参数名自动赋值了, 如果入参使用 @RequestParam("") 会根据具体的属性名去赋值
    @RequestMapping("/basic/one")
    @ResponseBody
    public String basicA(String a, String b) {
        // bbaa
        System.out.println(a + b);
        return a + b;
    }



    /*
    如果需要客户端传递多个对象,多个对象有相同的属性名.
    使用 InitBinder 可以指定对象前缀. 如果URL键没有前缀就会把值绑定到所有有该属性的对象.
     */
    @InitBinder("manager") // 指明映射到 @RequestMapping 方法参数名(第一个字母小写的类名, 与参数变量名无关)
    public void initManager(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("m1."); // 指明客户端参数前缀
    }

    @InitBinder("employee")
    public void initEmployee(WebDataBinder binder) {
        binder.setFieldDefaultPrefix("employee.");
    }

    // localhost:8080/dataBinder/multi-object?m1.name=a&employee.name=b&id=11
    @RequestMapping(path = "/multi-object")
    @ResponseBody
    public String multiObject(Manager m1, Employee employee) {
        // Manager{id='11', password='null', name='a', position='null', gender='null', phone='null', email='null'}
        // Employee{id='11', password='null', name='b'}
        System.out.println(m1 + "\n" + employee);
        return m1 + "\n" + employee;
    }

}
