GCWS通用课程网站系统
===================
开发规范目录结构
===============
...
```shell
├──src<br>
  ├──公用模块（如放DBUtil等)<br>
  ├──模块名1<br>
     ├──dao<br>
     ├──daoImpl<br>
     ├──servlet<br>
     ├──enitty<br>
  ├──模块名2<br>
     ├──dao<br>
     ├──daoImpl<br>
     ├──servlet<br>
     ├──entity<br>
...
├──webcontent<br>
  ├──公用模块（公用的js，css等）<br>
     ├──模块名1<br>
     ├──html<br><br>
     ├──javascript<br>
     ├──jsp<br><br>
     ├──css<br>
  ├──模块名2<br>
     ├──html<br>
     ├──javascript<br>
     ├──jsp<br><br>
     ├──css<br>
...
```
#
提交规范<br>
>>每个人只对自己的模块进行编码，确认项目能跑、不报错后才提交。<br>

>>实体定义	<br>
 
>>注意事项：<br>
>>1.	写明每个属性对应的哪个表的哪个字段，不然连表查询不知道是那张表的字段。<br>
>>2.	写完属性后，构造方法（带参构造方法和无参构造方法），以及setter和getter方法使用自动生成，避免出错。<br>
>>3.	实体的属性来源可以是多张表。<br>
>>4.	在一对多的情况下，可以在实体中使用ArrayList储存对应的多个实体。<br>
>>Dao层定义<br>
>>用注释写明每个方法的用处<br>
