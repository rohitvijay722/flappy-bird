import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
/*
<applet code="Checkiii" height=500 width=300></applet>
*/
public class Checkiii extends Applet implements KeyListener,Runnable
{
final public int width=300,height=500;
public int x=10,y=height/2;
public int score=0;
public int xOfRect=300,widthOfRect=20,height1OfRect=100,height2OfRect=380;
Thread t1;
Thread t2;
Ball b;
public void init()
{
y=height/2;//ss
score=0;
setBackground(Color.BLACK);////  
t1=new Thread(this);t1.start();
b=new Ball(this);
t2=new Thread(b);
t2.start();
showStatus("SCORE:"+score);
setSize(width,height);
this.addKeyListener(this);
}
public void paint(Graphics g)     ///
{
showStatus("SCORE:"+score+"     Press r/R to Restart");
g.setColor(Color.RED);
g.fillOval(x,y,15,15);
g.setColor(Color.GREEN);
g.fillRect(xOfRect,0,widthOfRect,height1OfRect);
g.fillRect(xOfRect,height1OfRect+60,widthOfRect,height2OfRect);
}
public void keyPressed(KeyEvent k)
{
int ch=k.getKeyCode();
if(ch==KeyEvent.VK_SPACE)
{
y-=70;
repaint();
}
}
public void keyReleased(KeyEvent k)
{}
public void keyTyped(KeyEvent k)
{
char ch=k.getKeyChar();
if(ch=='r'||ch=='R')
{ 
y=height/2;
score=0;
t1=new Thread(this);t1.start();
b=new Ball(this);
t2=new Thread(b);
t2.start();
showStatus("SCORE:"+score+"     Press r/R to Restart");
repaint();
}
}
public void run()
{
//xOfRect=((int)Math.random()*100);

outer:
while(true)
{
xOfRect=300;
height1OfRect=((int)((Math.random())*250));
height2OfRect=500-20-height1OfRect;
while(true)
{
if(xOfRect>-10)
{
try{
Thread.sleep(25);
}catch(InterruptedException er){System.out.println(er.getMessage());}
xOfRect-=1;
score++;
repaint();
if((y<(height1OfRect-2)&&xOfRect==x)||(y>(height1OfRect+52)&&xOfRect==x))
{
break outer;
}
}
else continue outer;
if(y>499)
break outer;
}
}
}
}

