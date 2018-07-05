这东西实现的是在，进行自动化脚本的时候一旦遇到报错将报错界面直接拿出来，可以方便快捷的扔到uiautomatorviewer中进行报错界面还原，方便捕捉界面的数据以外还可以快速进行代码的修改，实质原理的是在当前界面引入appium的driver然后通过获取当前界面的元素（一串<xml></xml>值）和当前界面的png截图，并且将该值（string）进行部分修改和拼装，来适应uiautomatorviewer中读取的uix代码逻辑。

使用代码的方法如下：

try{

}catch（e）
{
	在这里new并且传参
}

使用效果：
在该路径：包\\错误界面\\界面信息报错+发生错误时的时间戳\\
下生成三个文件stopScreen.png/stopScreen.uix/errorLog.txt文件，分别保存的是错误界面的png错误界面uix和catch到的e信息，或者你想传什么信息进去，errorlog就给你保存你要的信息
