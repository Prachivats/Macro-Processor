import java.io.*;
class Macrofinale
{
String s2=new String();
String s7=new String();
static int i=0;
static  int j=0;
static  int k=0;
static int q=0;
static int g=0;
static int mdlc=0;
static int o=0;
int flag=0;
int u=0,z=0;//ala index
static int n=0;
static int tr[]=new int[5];
static int sp=-1;
String s3=new String();
String s6=new String();
static String stck[]=new String[20];
static String c[]=new String[50];
String args[]=new String[6];//args array
char ch2[]=new char[6];
static int l=0;
static int a[]=new int[10];
static String b[]=new String[10];
static int d[]=new int[10];
static int e[]=new int[20];
InputStreamReader ir=new InputStreamReader(System.in);
BufferedReader br1=new BufferedReader(ir);
BufferedReader br;

void input2() throws IOException,NullPointerException
{
FileReader fin=new FileReader("input.txt");
br=new BufferedReader(fin);
}
void input()throws IOException,NullPointerException
{
System.out.println("Enter the Question");
InputStreamReader ir=new InputStreamReader(System.in);
BufferedReader br1=new BufferedReader(ir);
FileWriter fw=new FileWriter("input.txt");
BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw=new PrintWriter(fw);
String s=" ";
while(!s.equals("END"))
{

s=br1.readLine();

pw.println(s);

}
br1.close();
bw.close();
fw.close();
}
void read1()throws IOException,NullPointerException
{
String s7=myread();
int flag5=0;
char chm[]=s7.toCharArray();
int pk=48;
for(int ha=0;ha<s7.length();ha++)
{
	flag5=0;
	if(chm[ha]=='&')
	{
	for(int md=0;md<ch2.length;md++)
	{
		if(chm[ha+1]==ch2[md])
		{
		chm[ha]='#';
		chm[ha+1]=(char)(pk+md);
		flag5=1;
	
		}
		if(flag5==1)
		break;
	}
	}
}
s7=new String(chm);
mdt(s7);
if(s7.equals("MACRO"))
{
	mdlc++;
	read1();
}
else
{
	if(s7.equals("MEND"))
	{
		mdlc--;
		if(mdlc==0)
			read();
		else
			read1();
	}
	else
	{
	read1();
	}
}
}
String read2()throws IOException,NullPointerException
{
s6=br.readLine();
return s6;
}
void mdt(String s9)throws IOException,NullPointerException
{
c[l]=s9;//mdt array
g++;
e[l]=g;//mdtc array
l++;
}
void mnt(String s3)throws IOException,NullPointerException
{
			int count=1;
			flag=0;

			String s8=s3;
			char chw[]=s8.toCharArray();
			for(int g2=0;g2<chw.length;g2++)
			{		if(chw[g2]==',')
					count++;
			}
			
			String spr[];
			spr=s8.split(" ");
			String s91=spr[0];
			for(int j=0;j<b.length;j++)
			{
				if(s91.equals(b[j])&&flag!=1)
				{ 
					if(count==tr[j])
					{
						flag=1;
						int o=d[j];//mdt index from mnt entry
						push(s3,o);
						read();
					}
				}
			}
		if(flag==0)
		{	
			if(s3.equals("MACRO"))
			{
				String s9=read4();//Macro  name
				mdt(s9);
				int count1=1;
				char ch12[]=s9.toCharArray();
				 for(int g21=0;g21<ch12.length;g21++)
				{		
					if(ch12[g21]==',')
					count1++;
				}
						
				 ala(s9);
				 mdlc++;
				 String tan[];
				 tan=s9.split(" ");
				 int a5=l;
				 b[k]=tan[0];//mnt array
				 tr[k]=count1;
				 d[k]=a5;//mdtc array
				 k++;
				 read1();

			}
			 else
			  {
			  FileWriter fout=new FileWriter("output.txt",true);
			  PrintWriter pw=new PrintWriter(fout);
			  pw.println(s3);
			  fout.close();
			  pw.close();
			  if(s3.equals("END"))
			  System.exit(0);
			  else
			  read();
			  }
			
		}	
}
String myread()throws IOException,NullPointerException//this read is when we enter in mdt
{
	
	if(sp==-1)
	{
		String s7=read2();//second vala read when we do entry in mdt
		return s7;
	}
	else
	{
		String s8="";
		int str=Integer.parseInt(stck[sp+1]);
		int str1=str+1;
		s8+=str1;
		stck[sp+1]=s8;
		int v=Integer.parseInt(stck[sp+1]);
		v--;
		s7=substitute(c[v]);
		//left
		if(s7.equals("MEND"))
		{
			if(mdlc==0)
			{
			n=sp-Integer.parseInt(stck[sp])-2;
			sp=Integer.parseInt(stck[sp]);
			return s7;
			}
			else
			return s7;//check
		}
 
	}
	return s7;
}
String read4()throws IOException,NullPointerException//read of mdt,mnt
{
	if(sp==-1)
	{
		String s3=read2();
		return s3;
	}
	else
	{
		String s8="";
		int str=Integer.parseInt(stck[sp+1]);
		int str1=str+1;
		s8+=str1;
		stck[sp+1]=s8;
		int v=Integer.parseInt(stck[sp+1]);
		v--;
		s3=substitute(c[v]);
		//left
		if(s3.equals("MEND"))
		{
			if(mdlc==0)
			{
			n=sp-Integer.parseInt(stck[sp])-2;
			sp=Integer.parseInt(stck[sp]);
			return s3;
			}
			else
			return s3;
		}
 
	}
		return s3;
}
String substitute(String s23)throws NullPointerException
{

int p;
int x1=0;
int arg=0;
char ch23[]=s23.toCharArray();
	for(int g1=0;g1<s23.length();g1++)
			{       p=2;
				int n2=0;
				if(ch23[g1]=='#')
				{
					x1=g1;
					x1++;
					arg=ch23[x1]-48;
					while(arg!=p-2)
					{
						p++;
					}
					
					if(arg==p-2)
					{
						
						char cf[]=stck[sp+p].toCharArray();
						int x2=cf.length;
						int sh=0;
						if(cf.length==2)
						{
							for(sh=0;sh<cf.length;sh++)
							{
							ch23[g1]=cf[sh];
							g1++;
							}
						}	
						else if(cf.length==1)
							{
							ch23[g1]=cf[sh];
							for(int m3=x1;m3<s23.length();m3++)
							{
							if(m3<(s23.length()-1))
								ch23[m3]=ch23[m3+1];
							else
								ch23[m3]=' ';
							}
						
							}	
						
					}
				}
	
			}
	
	String s33=new String(ch23);
	
	return s33;
}
void read()throws IOException,NullPointerException//main read Ist wala 
{
	
	if(sp==-1)
	{
		
		String s3=read2();
		mnt(s3);

	}
	else
	{
		String s8="";
		int str=Integer.parseInt(stck[sp+1]);
		int str1=str+1;
		s8+=str1;
		stck[sp+1]=s8;
		int v=Integer.parseInt(stck[sp+1]);
		v--;
		s3=substitute(c[v]);
		if(s3.equals("MEND"))
		{
			if(mdlc==0)
			{
			n=sp-Integer.parseInt(stck[sp])-2;
			sp=Integer.parseInt(stck[sp]);
			read();
			}
			else
			  mnt(s3);
		}
		else
			 mnt(s3);
 
	}
}
void ala(String s9)
{
int flag1=0;
int r=0;
int t=0;
u=0;
char ch1[]=s9.toCharArray();
for(int z1=0;z1<s9.length();z1++)
{
if(flag1==0)
{
	if(ch1[z1]==' ')
	{
		flag1=1;
		r=z1;	
	}
}
}
t=r+1;//ch1 index
while(t<s9.length())
{
	if(ch1[t]!=','&&ch1[t]!='&')
	{
		ch2[u]=ch1[t];//to create ala
		
		u++;
		t++;
	}
	else
		t++;
}
}
void push(String s3,int o)
{
	
	String s10="";
	s10+=sp;
	stck[sp+n+2]=s10;//check
	sp=sp+n+2;
	int m1=2;
	String s8="";
	s8+=o;
	stck[sp+1]=s8;
	String fu[];
	fu=s3.split(" ");
	String fu1[];
	fu1=fu[1].split(",");
	for(int j1=0;j1<fu1.length;j1++)
	{
	stck[sp+m1]=fu1[j1];
	m1++;
	n++;
	}
	}
public static void main(String s1[])throws IOException,NullPointerException
{
Macrofinale m=new Macrofinale();
m.input();
m.input2();
m.read();

}
}

