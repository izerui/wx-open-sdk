# 微信开放平台sdk (基于retrofit2)

在你的项目中使用:

# gradle

第一步: 添加 JitPack repository
```xml
allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```
第二步: 添加依赖
```xml
dependencies {
	        compile 'com.github.izerui:wx-open-sdk:1.0-SNAPSHOT'
	}
```

# maven

第一步: 添加 JitPack repository
```xml
<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```
第二步: 添加依赖
```xml
<dependency>
	    <groupId>com.github.izerui</groupId>
	    <artifactId>wx-open-sdk</artifactId>
	    <version>1.0-SNAPSHOT</version>
	</dependency>
```

[![](https://jitpack.io/v/izerui/wx-open-sdk.svg)](https://jitpack.io/#izerui/wx-open-sdk)