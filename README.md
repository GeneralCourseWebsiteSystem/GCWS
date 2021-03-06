GCWS通用课程网站系统
===================
开发规范目录结构
--
```shell
...
├──src
|  ├──公用模块（如放DBUtil等)common
|  ├──模块名1
|     ├──dao
|     ├──impl
|     ├──servlet
|     ├──entity
|  ├──模块名2
|     ├──dao
|     ├──impl
|     ├──servlet
|     ├──entity
...
├──webcontent
|  ├──公用模块（公用的js，css等）common
|     ├──img
|     ├──css
|     ├──jsp
|     ├──js
|  ├──模块名1
|     ├──js
|     ├──jsp
|     ├──css
|  ├──模块名2
|     ├──js
|     ├──jsp
|     ├──css
...
```
#
## 提交规范
每个人只对自己的模块进行编码，确认项目能跑、不报错后才提交。
## 代码注释
* 所有自己写的方法、类、接口都需要加上注释 修改后同样需要增加注释  
`/**`   
 `* 新增或修改内容`  
 `* @author lxh`  
 `* @date 2018.6.28`  
 `*/`  
## 代码上传
#### 命令行上传代码操作

* 在进行代码的push到仓库之前，请先将本地仓库的代码更新，即先pull一次，确定不会报错，没有冲突，再进行push  
#### eclipse上传代码操作
* 右键GCWS -> team -> Synchronize Workspace -> 查看上传文件 **确保无误** -> 将要上传的文件Add to index 并且在旁边**写上注释**   
-> commit and push ->  push
#
## 实体定义
连表查询需要给每个属性写上表名和字段
#
## 注意事项
1.	写明每个属性对应的哪个表的哪个字段，不然连表查询不知道是那张表的字段。<br>
2.	写完属性后，构造方法（带参构造方法和无参构造方法），以及setter和getter方法使用自动生成，避免出错。<br>
3.	实体的属性来源可以是多张表。<br>
4.	在一对多的情况下，可以在实体中使用ArrayList储存对应的多个实体。<br>
5. 程序要保证前台和后台的控制台不要报错，完成后把浏览器控制台输出的内容清掉。<br>
#
## Dao层定义
用注释写明每个方法的用处<br>
#
## 索引
[后台登录](http://localhost:8080/GCWS/BackManagementQuit).
[前台](http://localhost:8080/GCWS/HomePage).
