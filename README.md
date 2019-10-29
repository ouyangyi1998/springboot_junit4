# springboot_junit4
junit4联动springboot，对于web开发进行测试
- 需要spring.test junit包，前端页面采用thymeleaf进行渲染
- thymeleaf的循环语法
```
 <tr th:if="${list!=null}" th:each="item:${list}">
            <td th:text="${item.name}"></td>
            <td th:text="${item.age}"></td>
            <td th:text="${#dates.format(item.createDate,'yyyy-MM-dd')}"></td>
 </tr>
 ```
 - #datas.format(item.createDate,'yyyy-mm-dd') 可以对后台建立的new Date()进行封装
- th:each="itew :${list}" 建立item 遍历list集合(前端菜鸟学到了。。。)
- MockMvc 可以操作请求，在test中@autowired webApplicationContext 然后在@Before中利用建造者模式构造之后可以进行操作
```
@Before
    public void before()
    {
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
 ```
 - 通过perform发送请求(post,get),进行测试与返回json
 - mvcResult.getResponse().getStatus() 返回http状态码
 -  String resString=mvcResult.getResponse().getContentAsString() 返回json数据
 ```
 MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.get("/user/list")).andReturn();
        int status=mvcResult.getResponse().getStatus();
        String resString=mvcResult.getResponse().getContentAsString();
 ```
 -  Assert.assertEquals("fail",200,status) 对于返回结果进行判断  "fail"错误报告 http：200 预期结果  status真实结果
