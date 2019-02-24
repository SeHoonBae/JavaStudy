package example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Array2_6_10 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
//		q6(reader);
//		q7(reader);
		q8(reader);
//		q9(reader);
//		q10(reader);
	}

	private static void q10(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.print("국어점수 : ");
		int kor = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수 : ");
		int eng = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수 : ");
		int math = Integer.parseInt(reader.readLine());
		
		String[][] score = new String[10][3];
		
		int korString = kor/10;
		int engString = eng/10;
		int mathString = math/10;
		
		for(int i=score.length-1; i>=score.length-korString; i--) 
			score[i][0]="■";
		
		for(int i=score.length-korString-1; i>=0; i--)
			score[i][0]="";
		
		for(int i=score.length-1; i>=score.length-engString; i--) 
			score[i][1]="■";
		
		for(int i=score.length-engString-1; i>=0; i--)
			score[i][1]="";
		
		for(int i=score.length-1; i>=score.length-mathString; i--) 
			score[i][2]="■";
		
		for(int i=score.length-mathString-1; i>=0; i--)
			score[i][2]="";
		
		for(int i=0; i<score.length; i++) {
			for(int j=0; j<score[i].length; j++) {
				System.out.print(score[i][j]+"\t");
			}
			System.out.println();
			
		}
		System.out.println("국어\t영어\t수학");
		
	}
	// 마방진 세로, 가로, 대각선 합 구하는 공식 n*(n*n+1)/2
	// 
	private static void q9(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.print("홀수 정사각형의 한변 길이를 정하세요. : ");
		int row = Integer.parseInt(reader.readLine());
		
		int[][] table = new int[row][row];
		int num = 1;
		Random random=new Random();
		
		
//		int k=0;
//		int i=0;
//		int j=row/2;
//		
//		while(k<row*row) {
//			
//			table[i][j]=num;
//			num++;
//			
//			if(num%row==1) { // row의 배수 +1 값은 아래행으로 이동
//				i++;
//				if(i == row) i=0;
//			}
//			else {
//				i--;
//				j--;
//				
//				if(i == -1) i=row-1;
//				if(j == -1) j=row-1;
//			}
////			if(table[i][j] != 0) { // 넣고자 하는 자리에 값이 있을 경우 아래행으로 이동
////				i+=2;
////				j++;
////				i=i%row;
////				j=j%row;
////			}
//			
//			k++;
//		}
		
		// 오른쪽 대각선 위로 이동
		int k=0;
		int i=row/2;
		int j=0;
		
		while(k<row*row) {
			
			table[i][j]=num;
			num++;
			
			if(num%row==1) {
				j--;
				if(j == -1) j = row-1;
			}
			else {
				i--;
				j++;
				if(i == -1) i = row-1;
				if(j == row) j = 0;
			}
			
			k++;
		}
		
		
		
		
		for(int[] c : table) {
			for(int d : c)System.out.print(d+"\t");
			System.out.println();
		}
		
		
	}

	private static void q8(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.print("행을 길이를 입력하세요. : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열을 길이를 입력하세요. : ");
		int col = Integer.parseInt(reader.readLine());
		
		
			
		int[][] table = new int[row][col];
		int num = 1; // 넣을 숫자
		int s = 1; // 행,열을 조절해 줄 숫자 1, -1 왔다 갔다함
		int a = 0; // 행
		int b = -1; // 열
		int k=0; //몇번 반복할지, 제일 마지막에는 row가 0이되어 두번째 for문 안돌아감, 즉, 행의 길이가 1까지 돌림
			
		while(k<5) {
			for(int i=0; i<col; i++) {
				b+=s;
				table[a][b]=num;
				num++;
			}
			col--;
			row--;
			
			for(int i=0; i<row; i++) {
				a+=s;
				table[a][b]=num;
				num++;
			}
			s=s*-1;
			k++;
		}
				
		for(int[] c : table) {
			for(int d : c)System.out.print(d+"\t");
			System.out.println();
		}
		
	}

	private static void q7(BufferedReader reader) throws NumberFormatException, IOException {
		
		System.out.print("행을 길이를 입력하세요. : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열을 길이를 입력하세요. : ");
		int col = Integer.parseInt(reader.readLine());
		
		int[][] table = new int[row][col];
		int num=1;
		int totalResult=0;
		int rowResult=0;
		int colResult=0;
		
		for(int i=0; i<row-1; i++) {
			for(int j=0; j<col-1; j++) {
				table[i][j]=num;
				totalResult+=num;
				num++;
				colResult+=table[i][j];				
			}
			table[i][col-1]=colResult;
			
			colResult=0;
			
		}
		
		for(int i=0; i<col-1; i++) {
			for(int j=0; j<row-1; j++) {
				rowResult+=table[j][i];
			}
			table[row-1][i]=rowResult;
			rowResult=0;
		}
		table[row-1][col-1]=totalResult;
		
		
		
		print1(table);
		
	}

	private static void q6(BufferedReader reader) throws NumberFormatException, IOException {

		System.out.print("행을 길이를 입력하세요. : ");
		int row = Integer.parseInt(reader.readLine());
		System.out.print("열을 길이를 입력하세요. : ");
		int col = Integer.parseInt(reader.readLine());
		
		int[][] table = new int[row][col];
		int num=1;
		
		int k=0;
		int a;
		
		for(int i=0; i<col; i++) {
			k=0;
			a=i;
			
			while(k<=i) {
			table[k][a]=num;
			num++;
			a--;
			k++;
			}
		}
		
		for(int i=1; i<row; i++) {
			k=4;
			a=i;
			
			while(k>=i) {
				table[a][k]=num;
				num++;
				a++;
				k--;
			}
		}
		
		print1(table);
		
		
	}
	
	private static void print1(int[][] num) {
		for(int[] i:num) {
			for(int j : i) System.out.print(j+"\t");
			System.out.println();
		}
	}
}
