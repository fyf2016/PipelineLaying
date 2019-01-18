# PipelineLaying

[![HitCount](http://hits.dwyl.io/fyf2016/PipelineLaying.svg)](http://hits.dwyl.io/fyf2016/PipelineLaying) [![GitHub license](https://img.shields.io/github/license/fyf2016/PipelineLaying.svg)](https://github.com/fyf2016/PipelineLaying/blob/master/LICENSE) [![Download](https://img.shields.io/badge/downloads-master-orange.svg)](https://codeload.github.com/PipelineLaying/zip/master) 
[![Gitter](https://img.shields.io/gitter/room/fyf2016/PipelineLaying.svg)](https://gitter.im/PipelineLaying/community?utm_source=share-link&utm_medium=link&utm_campaign=share-link)

[项目开发流程和演示](https://fyf2016.github.io/2018/07/22/%E7%AE%97%E6%B3%95%E4%B8%89%E7%BA%A7%E9%A1%B9%E7%9B%AE/)

>管道铺设项目( 算法三级项目 )

## 项目简介
课程的三级项目是要求设计实现一个管线铺设辅助系统，设计算法并实现使铺设的输水管道距离最短。本项目主要应用了最小生成树算法：prime算法和Kruskal算法两种算法，具备从文本读取数据、显示最佳铺设方案，以及绘制最佳方案的简单示意图等功能，以燕山大学东校区各建筑物为例，实现了获得任意两个建筑物之间铺设管道的最佳方案。

## 特点

- javaWeb项目, 界面美观, 与用户的交互性好。
- 核心功能的实现采用了Prime算法和Kruskal算法。
- 引入百度地图api, 最终路线的生成较为直观。
- 可动态的添加或删除途经的建筑(节点)。

## 项目主要界面展示
 >首页
 
![首页](https://fyf2016.github.io/images/project/arithmetic/index.png)
>节点信息展示

![节点信息展示](https://fyf2016.github.io/images/project/arithmetic/nodeMsg.png)
>Prime算法界面

![Prime算法界面](https://fyf2016.github.io/images/project/arithmetic/prime.png)
>Kruskal算法界面

![Kruskal算法界面](https://fyf2016.github.io/images/project/arithmetic/kruskal.png)
>最终生成的路线图

![最终生成的路线图](https://fyf2016.github.io/images/project/arithmetic/map.png)

## 视频演示地址
> [bilibili上演示地址](https://www.bilibili.com/video/av40697433/)

> [腾讯云对象存储COS视频地址](https://video-1254265973.cos.ap-beijing.myqcloud.com/arithmetic.mp4)

## 项目配置
>1. 矩阵文件格式

矩阵文件的格式应为N*2矩阵, 形式如 AB 150 。A, B 为结点的编号, 150为两结点结点间的距离。
详细配置可参照项目中的ReadDatas.txt和ReadDatas3.txt。

 >2. 读入文件路径的设置
 
读入文件的路径设置在 PipeLineLaying/src/com/dao/impl/ReadDataDAOImpl.java 里面修改,
修改位置为下图标红线的地方:

-------------------------------------------------------------------------------------

![读入文件路径的设置](https://fyf2016.github.io/images/project/arithmetic/readPath.png)

-------------------------------------------------------------------------------------

>3. 输出文件路径的设置

输出最终结果的路径设置在 PipeLineLaying/src/com/dao/impl/OutputDataDAOImpl.java 里面修改,
修改位置为下图标红线的地方:

-------------------------------------------------------------------------------------

![输出文件路径的设置](https://fyf2016.github.io/images/project/arithmetic/outputPath.png)

-------------------------------------------------------------------------------------

>4. 数据库配置

(1) 数据库连接信息可在项目下的 src/jdbc.properties 文件中修改,
    下图标红线的位置对应的是 自己数据库的名字(类型为Mysql数据库)。
    
-------------------------------------------------------------------------------------
![数据库配置文件](https://fyf2016.github.io/images/project/arithmetic/jdbc.png)

-------------------------------------------------------------------------------------

(2) 将项目中的 pipelying.sql 导入自己电脑的本地数据库
    演示Navicat导入的方式:
    右键连接–>选择运行SQL文件–>选中pipelying.sql–>运行完毕点击关闭–>右键刷新。
    完成以上步骤后, pipelying数据库便成功导入到了你的本地数据库中。
    
 -------------------------------------------------------------------------------------
 ![导入数据库方式](https://fyf2016.github.io/images/project/arithmetic/database.png)
 
 -------------------------------------------------------------------------------------



