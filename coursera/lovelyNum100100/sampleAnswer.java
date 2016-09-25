/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author shivam
 */
public class Main {
	public static void main(String[]args) throws IOException
	{
		BufferedReader n=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(n.readLine());
		for(int i=0;i<N;i++)
		{
			int p=Integer.parseInt(n.readLine());
			String bin=Integer.toBinaryString(p);
			if(bin.length()%2==1)
			{
				System.out.println("Not Lovely");
			}
			else{
				int flag=0;
				for(int o=0;o<bin.length()/2;o++)
				{
					if(bin.charAt(o)!=bin.charAt(o+bin.length()/2))
					{
						System.out.println("Not Lovely");flag=1;
						break;
					}
				}
				if(flag==0)
				{
					System.out.println(Integer.parseInt(bin.substring(0, bin.length()/2),2));
				}
			}
		}
	}

}

