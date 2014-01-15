

遥控机器人游戏
=================

需求描述：


一个机器人可以通过手机远程控制行进的路线。机器人的位置和方向将由一个X,Y坐标系和方向字母表示。坐标系左上角坐标为0，0，方向由N, S, E, W进行表示，例如：0，0，S，表示当前位于坐标系左上角，且面朝南方。手机在控制机器人时，会发送一系列的指令，'L', 'R'代表使向左和向右旋转90度但保持当前坐标位置不变，'F', 'B'代表使机器人前进和后退一个坐标的位置但保持方向不变。



其它要求：

1、第一行输入指定坐标系大小

2、第二行输入决定机器人的初始位置

3、后续输入为控制命令

玩法
==================

启动应用，会提示输入坐标系大小及初始位置。如果输入格式不正确，默认的坐标系大小为：7 7 ,初始位置为：0 0 S.

启动应用后，请直接按键盘上的按键: 

R ->向右转

L ->向左转

F ->前进

B ->后退

