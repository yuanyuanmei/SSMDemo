# mybaitis-config 全局配置属性（按需引入）

    <!--配置缓存，默认为true-->
    <setting name="cancheEnabled" value="true"/>

    <!--延迟加载的全局开关。特定关联关系可通过设置fetchType属性覆盖该项的开关 默认为false-->
    <setting name="lazyLodingEnabled" value="true"/>

    <!--当启用时，对任意延迟属性的调用会使带有延迟加载属性的对象完全加载，反之按需加载 默认为true-->
    <setting name="aggressiveLazyLoading" value="true"/>

    <!--是否允许单一语句返回多结果集,默认为true-->
    <setting name="multipleResultSetsEnabled" value="true"/>

    <!--使用列标签代替列名。默认为true-->
    <setting name="useColumnLabel" value="true"/>

    <!--支持自动生成主键 默认为false-->
    <setting name="useGeneratedKeys" value="true"/>

    <!--指定mybatis应如何自动映射列到字段或属性 NONE表示取消自动映射 PARTIAL 只会自动映射嵌套结果集映射的结果集。FULL 会自动映射任意复杂结果集-->
    <setting name="autoMappingBehavior" value="PARTIAL"/>

    <!--配置默认的执行器。SIMPLE就是普通的执行器；REUSE执行器会重用预处理语句 SIMPLE REUSE BATCH-->
    <setting name="defaultExecutorType" value="SIMPLE"/>

    <!--设置超时时间-->
    <setting name="defaultStatementTimeout" value="60"/>

    <!--允许在嵌套中使用分页-->
    <setting name="safeRowBoundsEnabled" value="false"/>

    <!--是否自动开启驼峰命名规则映射-->
    <setting name="mapUnderscoreToCamelCase" value="true"/>

    <!--mybatis利用本地缓存机制 SESSION STATEMENT-->
    <setting name="localCacheScope" value="SESSION"/>
    
    
# 

# git 用法
---------------------------------------------------------------------------------
\#               表示此为注释,将被Git忽略
*.a             表示忽略所有 .a 结尾的文件
!lib.a          表示但lib.a除外
/TODO           表示仅仅忽略项目根目录下的 TODO 文件，不包括 subdir/TODO
build/          表示忽略 build/目录下的所有文件，过滤整个build文件夹；
doc/*.txt       表示会忽略doc/notes.txt但不包括 doc/server/arch.txt

bin/:           表示忽略当前路径下的bin文件夹，该文件夹下的所有内容都会被忽略，不忽略 bin 文件
/bin:           表示忽略根目录下的bin文件
/*.c:           表示忽略cat.c，不忽略 build/cat.c
debug/*.obj:    表示忽略debug/io.obj，不忽略 debug/common/io.obj和tools/debug/io.obj
**/foo:         表示忽略/foo,a/foo,a/b/foo等
a/**/b:         表示忽略a/b, a/x/b,a/x/y/b等
!/bin/run.sh    表示不忽略bin目录下的run.sh文件
*.log:          表示忽略所有 .log 文件
config.php:     表示忽略当前路径的 config.php 文件

/mtk/           表示过滤整个文件夹
*.zip           表示过滤所有.zip文件
/mtk/do.c       表示过滤某个具体文件

被过滤掉的文件就不会出现在git仓库中（gitlab或github）了，当然本地库中还有，只是push的时候不会上传。

需要注意的是，gitignore还可以指定要将哪些文件添加到版本管理中，如下：
!*.zip
!/mtk/one.txt

唯一的区别就是规则开头多了一个感叹号，Git会将满足这类规则的文件添加到版本管理中。为什么要有两种规则呢？
想象一个场景：假如我们只需要管理/mtk/目录中的one.txt文件，这个目录中的其他文件都不需要管理，那么.gitignore规则应写为：：
/mtk/*
!/mtk/one.txt

假设我们只有过滤规则，而没有添加规则，那么我们就需要把/mtk/目录下除了one.txt以外的所有文件都写出来！
注意上面的/mtk/*不能写为/mtk/，否则父目录被前面的规则排除掉了，one.txt文件虽然加了!过滤规则，也不会生效！

还有一些规则如下：
fd1/*
说明：忽略目录 fd1 下的全部内容；注意，不管是根目录下的 /fd1/ 目录，还是某个子目录 /child/fd1/ 目录，都会被忽略；

/fd1/*
说明：忽略根目录下的 /fd1/ 目录的全部内容；

/*
!.gitignore
!/fw/
/fw/*
!/fw/bin/
!/fw/sf/
----------------------------------------------------------------------------------


=======sql========
/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 5.6.24-log : Database - questionnaire
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`questionnaire` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `questionnaire`;

/*Table structure for table `public_perms` */

DROP TABLE IF EXISTS `public_perms`;

CREATE TABLE `public_perms` (
  `id` int(1) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `type` int(1) NOT NULL COMMENT '类型 1菜单 2功能',
  `parentid` int(1) NOT NULL COMMENT '父级编号',
  `url` varchar(255) NOT NULL COMMENT '菜单地址',
  `icon` varchar(50) NOT NULL COMMENT '菜单图标标识',
  `permission` varchar(255) NOT NULL COMMENT '授权标识，多个以,分隔',
  `status` int(1) NOT NULL DEFAULT '1' COMMENT '权限状态 1正常 2禁用',
  `remark` varchar(500) NOT NULL COMMENT '备注',
  `ranking` int(1) NOT NULL DEFAULT '0' COMMENT '排序',
  `createtime` datetime NOT NULL COMMENT '添加时间',
  `is_delete` int(1) NOT NULL DEFAULT '1' COMMENT '是否删除 1未删除 2已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='后台菜单权限表';

/*Data for the table `public_perms` */

insert  into `public_perms`(`id`,`name`,`type`,`parentid`,`url`,`icon`,`permission`,`status`,`remark`,`ranking`,`createtime`,`is_delete`) values (1,'系统管理',1,0,'sys/setting','admin','',1,'系统设置',0,'2019-05-23 16:11:49',1),(2,'用户管理',1,1,'sys/user','admin','',1,'用户设置',0,'2019-05-23 16:11:49',1),(3,'用户添加',2,2,'','admin','sys:user:save',1,'用户添加',0,'2019-05-23 16:11:49',1),(4,'用户修改',2,2,'','admin','sys:user:update',1,'用户修改',0,'2019-05-23 16:11:49',1),(5,'用户删除',2,2,'','admin','sys:user:delete',1,'用户删除',0,'2019-05-23 16:11:49',1),(6,'用户列表',2,2,'','admin','sys:user:list',1,'用户列表',0,'2019-05-23 16:11:49',1),(7,'用户授权',2,2,'','admin','sys:user:grant',1,'用户授权',0,'2019-05-23 16:11:49',1),(8,'角色管理',1,1,'sys/role','admin','',1,'角色设置',0,'2019-05-23 16:11:49',1),(9,'角色添加',2,8,'','admin','sys:role:save',1,'角色添加',0,'2019-05-23 16:11:49',1),(10,'角色修改',2,8,'','admin','sys:role:update',1,'角色修改',0,'2019-05-23 16:11:49',1),(11,'角色删除',2,8,'','admin','sys:role:delete',1,'角色删除',0,'2019-05-23 16:11:49',1),(12,'角色列表',2,8,'','admin','sys:role:list',1,'角色列表',0,'2019-05-23 16:11:49',1),(13,'权限管理',1,1,'sys/menu','admin','',1,'权限设置',0,'2019-05-23 16:11:49',1),(14,'权限添加',2,13,'','admin','sys:menu:save',1,'权限添加',0,'2019-05-23 16:11:49',1),(15,'权限修改',2,13,'','admin','sys:menu:update',1,'权限修改',0,'2019-05-23 16:11:49',1),(16,'权限删除',2,13,'','admin','sys:menu:delete',1,'权限删除',0,'2019-05-23 16:11:49',1),(17,'权限列表',2,13,'','admin','sys:menu:list',1,'权限列表',0,'2019-05-23 16:11:49',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

==================
今日思考：
1.AOP 切面编程的作用不就是抽离公共部分处理吗，那项目中的哪些地方重复操作比较严重呢？
2.所有Controller的校验方法可否抽离出来，结合自定义注解实现AOP切面呢？？
