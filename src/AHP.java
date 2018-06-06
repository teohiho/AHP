import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class AHP {
	
	
	
	static float[][] readFileData(String fileName) {
		File file = new File(fileName);
		String result = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			try {

				while ((line = br.readLine()) != null) {
					result = result + line + "\n";
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Matrix:\n" + result);
		String[] data = result.split("\n");
		
		value = data.length;
		value = ((data[0]).split("\\s")).length;
		float[][] matrix = new float[value][value];
		for (int i = 0; i < value; i++) {
			String[] stA = data[i].split("\\s");
			for (int j = 0; j < value; j++) {
				matrix[i][j] = Float.parseFloat(stA[j]) ;
			}
		}
		return matrix;
	}
	static void OutMatix(Matrix m)
	{
		System.out.println("\n");
	    DecimalFormat f = new DecimalFormat("0.000");
		
		for(int i=0;i<m.value;i++) {
			for(int j=0;j<m.value;j++)
			{
				if(m.arr[i][j] == -1 ) System.out.print("\t");
				else {
					System.out.print(f.format(m.arr[i][j])+"\t");
				}
			}
		System.out.println("\n");   
			
		}
	}
	static void OutMatrix(float[] Matrix)
	{
		System.out.println("\n");
	    DecimalFormat f = new DecimalFormat("0.000");
	    
	    for(int i=0;i<value;i++) {
				System.out.print(f.format(Matrix[i])+"\t");
			}
		System.out.println("\n");   
			
	}
	static  int value;
	public static void main(String[] args)
	{
		
		Matrix MatrixA ;
		
		String fileName = "test.txt";
		File file = new File(fileName);
		
		
		MatrixA = new Matrix(readFileData(fileName));
		MatrixA.value = value;
		System.out.println("TIEU CHI:");
		System.out.println("-----------------------------------");
		System.out.println("Ma tran he so quang trong tuong doi");
		OutMatix(MatrixA);
		float[] RankingA = MatrixA.RankingVecto();
		System.out.println("-----------------------------------");
		
		
		
		
		Matrix MatrixB ;
		
		fileName = "salary.txt";
		File file1 = new File(fileName);
		
		
		MatrixB = new Matrix(readFileData(fileName));
		MatrixB.value = value;
		System.out.println("SALARY:");
		System.out.println("-----------------------------------");
		System.out.println("Ma tran he so quang trong tuong doi");
		OutMatix(MatrixB);
		float[] RankingB = MatrixB.RankingVecto();
		System.out.println("-----------------------------------");
		
		
		
		Matrix MatrixC ;
		
		fileName = "life.txt";
		File file2 = new File(fileName);
		
		
		MatrixC = new Matrix(readFileData(fileName));
		MatrixC.value = value;
		System.out.println("LIFE QUALITY:");
		System.out.println("-----------------------------------");
		System.out.println("Ma tran he so quang trong tuong doi");
		OutMatix(MatrixC);
		float[] RankingC = MatrixC.RankingVecto();
		System.out.println("-----------------------------------");
		
		
		Matrix MatrixD ;
		
		fileName = "interest.txt";
		File file3 = new File(fileName);
		
		
		MatrixD = new Matrix(readFileData(fileName));
		MatrixD.value = value;
		System.out.println("INTEREST:");
		System.out.println("-----------------------------------");
		System.out.println("Ma tran he so quang trong tuong doi");
		OutMatix(MatrixD);
		float[] RankingD = MatrixD.RankingVecto();
		System.out.println("-----------------------------------");
		
		
		Matrix MatrixE ;
		
		fileName = "nearness.txt";
		File file4 = new File(fileName);
		
		
		MatrixE = new Matrix(readFileData(fileName));
		MatrixE.value = value;
		System.out.println("NEARNESS:");
		System.out.println("-----------------------------------");
		System.out.println("Ma tran he so quang trong tuong doi");
		OutMatix(MatrixE);
		float[] RankingE = MatrixE.RankingVecto();
		System.out.println("-----------------------------------");
		
		
		///---------------------------------------------///
		
		float[] kq =  new float[RankingB.length];
		float[] sum =  new float[3];
		
		kq = NhanMT(RankingA[0], RankingB);
		System.out.println("SALARY:"+RankingA[0]);
		for(int i = 0;i<RankingB.length;i++)
		{
				System.out.print(kq[i]+"\t");
				sum[i]+=kq[i]; 
		}
		System.out.println("\n");
		kq = NhanMT(RankingA[1], RankingC);
		System.out.println("LIFE QUALITY:"+RankingA[1]);
		for(int i = 0;i<RankingC.length;i++)
		{
				System.out.print(kq[i]+"\t");
				sum[i]+=kq[i]; 
  
		}
		System.out.println("\n");
		
		kq = NhanMT(RankingA[2], RankingD);
		System.out.println("INTEREST:"+RankingA[2]);
		for(int i = 0;i<RankingD.length;i++)
		{
				System.out.print(kq[i]+"\t");
				sum[i]+=kq[i]; 
		}
		System.out.println("\n");
		
		kq = NhanMT(RankingA[3], RankingE);
		System.out.println("NEARNESS:"+RankingA[3]);
		for(int i = 0;i<RankingE.length;i++)
		{
				System.out.print(kq[i]+"\t");
				sum[i]+=kq[i]; 
		}
		System.out.println("\n");
		
		System.out.println("OVERALL:");
		for(int i = 0;i<sum.length;i++)
		{
				System.out.print(sum[i]+"\t");
		}
		

		
	}

	static float[] NhanMT(float A, float[] B)
	{
		float[]kq = new float[B.length];
		for(int i = 0;i<B.length;i++)
		{
			
				kq[i] = A*B[i];
		}
		return kq;
	}
}
