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

