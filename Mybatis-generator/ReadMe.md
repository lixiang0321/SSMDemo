该代码生成器可生成pojo，dao增删该查，service增删改查
以及mybatis对应的xml上面的增删该查操作。

使a用前先予以更改dtabase.properties下面的jar包位置
设置自己的jar包位置，本人在开发的时候从不将代码放置在
中文的目录下，我也建议你这样做。同时设置你想要生成的数据库
并且，设置好相应的账号以及密码。

最后请先阅读同一目录下面的配置文件，并且设置好，您想要
生成代码的风格，以及pojo中的一些常用方法，最后如果您想要
运行此文件，在idea上面配置一个可运行的maven，工作目录就是
本Maven 至于命令则为 mybatis-generator:generate -e
运行即可，命令我未检查，如果错了，百度一下~~~~
祝您开发愉快