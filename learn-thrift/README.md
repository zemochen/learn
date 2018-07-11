# Thrift RPC框架

## 简介

> Thrift是一个有facebook开发的RPC软件框架，用来进行可扩展且跨语言的服务的开发。
   它结合了功能强大的软件堆栈和代码生成引擎，以构建在 C++, Java, Python, PHP, 
   Ruby, Erlang, Perl, Haskell, C#, Cocoa, JavaScript, Node.js, Smalltalk, and OCaml 
   等等编程语言间无缝结合的、高效的服务。
 
 
## 安装Thrift
下文为OS X下的安装过程更多安装教程详见:
<http://thrift.apache.org/docs/install/>
* [Centos 6.5 Install](http://thrift.apache.org/docs/install/centos)
* [Debian/Ubuntu install](http://thrift.apache.org/docs/install/debian)
* [Windows Install](http://thrift.apache.org/docs/install/windows)

### OS X

执行`brew install thrift` 或如下使用源码包安装
#### Install Boost
Download the boost library from [boost.org](ttp://www.boost.org/) untar compile with

```
./bootstrap.sh
sudo ./b2 threading=multi address-model=64 variant=release stage install
```
#### Install libevent
Download [libevent](http://libevent.org/), untar and compile with
```
./configure --prefix=/usr/local 
make
sudo make install
```
#### Building Apache Thrift
Download the latest version of [Apache Thrift](http://thrift.apache.org/download), untar and compile with

```
./configure --prefix=/usr/local/ --with-boost=/usr/local --with-libevent=/usr/local
```

