import java.util.Scanner;
public class shiyan3 {
	static int ps = 0;
	static int[] route = new int[10];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{0,5,3,8,9,0,0,0,0,0},{5,0,4,0,0,0,0,6,8,0},{3,0,0,0,0,0,6,5,0,0},{8,0,0,0,7,5,6,0,0,0},{9,0,0,7,0,8,0,0,0,0},{0,0,0,5,8,0,4,0,0,0},{0,0,6,6,0,4,0,0,0,9},{0,6,5,0,0,0,0,0,4,0},{0,8,0,0,0,0,0,4,0,5},{0,0,0,0,0,0,9,0,5,0}};
		boolean[] y = {false,false,false,false,false,false,false,false,false,false} ;
		int[] luxian = new int[10];
		Scanner in = new Scanner(System.in);
		System.out.println("请输入您旅行的出发点(景点代号)");
		int init = in.nextInt();
		dfs(0,false,0,init,y,a,luxian,0,init);
		System.out.println("您此次旅行的路线最小权重为:"+ps);
		System.out.print("您此次旅行所应走的线路为(景点代号):");
		for(int r = 0 ; r<=9 ; r++) {
			System.out.print(route[r]+" ");
		}
	}
	
	public static void dfs(int step , boolean b , int total , int next , boolean[] used , int[][] a , int[] k ,int s,int ko) {
		if(step==10 && b && next==ko) {
			if(ps==0) {
				ps=total;
				for(int r = 0 ; r<=9 ; r++) {
					route[r]=k[r];
				}
				route[9] = ko;
			}
			if(total <ps) {
				ps = total;
				for(int r = 0 ; r<=9 ; r++) {
					route[r]=k[r];
				}
				route[9] = ko;
			}
		}
		if(used[next]==false) {
			
		
			for(int i = 0 ; i<=9 ; i++) {
				if(a[next][i]!=0) {
					step++;
					used[next]=true;
					k[s]=next;
					s++;
					total+=a[next][i];
					int u = 0;
					for(int j = 0 ; j<=9 ; j++) {
						if(used[j]==true) {
							u++;
						}
					}
					if(u==10) {
						b=true;
					}
					dfs(step , b , total , i , used , a , k ,s,ko);
					s--;
					k[s]=0;
					used[next] = false;
					total-=a[next][i];
					step--;
				}
			}
		}
	}
}
