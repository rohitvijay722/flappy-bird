class Ball implements Runnable
{
Checkiii c;
Ball(Checkiii x)
{
c=x;
}
public void run()
{
while(c.y<500)
{
c.y=c.y+1;
c.repaint();
if((c.y<(c.height1OfRect-2)&&c.xOfRect==c.x)||(c.y>(c.height1OfRect+52)&&c.xOfRect==c.x))
{
break;
}
if(c.y<5)
{
c.y=10;c.repaint();
}
if(c.y>499)
break;
try{
Thread.sleep(25);
}catch(InterruptedException er){System.out.println(er.getMessage());}
}
}
}