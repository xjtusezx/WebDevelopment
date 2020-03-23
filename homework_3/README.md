# Todo List(node)

1.使用node框架，构建一个Restful API

2.完成todo list功能

3.使用面像对象的思路来构建





#### 以下是题目要求

***

> # Todo list
> 
> 使用node框架，构建一个Restful API，能够完成Todo list的以下功能。
>
> - 返回所有Todo任务
>    - 创建一个新的Todo任务
>    - 返回一个指定ID的Todo任务
>    - 删除一个Todo任务
>    
>    为简化流程，不引入数据存储，即，不需要做数据持久化，可以在服务器运行时满足功能即可。
>
> Todo中一个任务的JSON格式定义为：
>
>    ```
>  {
>     "id": 1,
>    "content": "Restful API homework",
>     "createdTime": "2019-05-15T00:00:00Z"
>  }
> ```
>
>    进一步的功能提示：需完成的四个功能的Restful API定义如下，实现即可。
>
> ```
>GET /api/tasks/
> POST /api/tasks/
> GET /api/tasks/{id}
>DELETE /api/tasks/{id}
> ```

### 遇到的困难及解决方法

* npm install 速度过慢，通过修改淘宝镜像解决
* 使用不同的get和post请求方法来解决处理不同相应的问题
* node_module过大，故不push到github上