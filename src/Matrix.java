import java.text.DecimalFormat;

public class Matrix {
	int value;
	float[][] arr;
	
	public Matrix(float[][] arr)
	{
		this.arr = arr;
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
	    
	    for(int i=0;i<Matrix.length;i++) {
				System.out.print(f.format(Matrix[i])+"\t");
			}
		System.out.println("\n");   
			
	}
	public float[] RankingVecto()
	{
		// Sum
		float[] S = new float[this.value];
		for(int j=0;j<this.value;j++)
		{
			float sum = 0;
			for(int i=0;i<this.value;i++)
			{
				sum+= this.arr[i][j];
			}
			S[j] = sum;
		}
		System.out.println("Sum: ");

		OutMatrix(S);
		
		
		// Ma tran B
		Matrix MatrixB = new Matrix(new float[this.value][this.value]);
		MatrixB.value = this.value;
		
		float[] Ranking =  new float[this.value];
		for(int i=0;i<this.value;i++)
		{
			float sum = 0;
			for(int j=0;j<this.value;j++)
			{
				MatrixB.arr[i][j] = this.arr[i][j] / S[j];
				sum+= MatrixB.arr[i][j];
			}
			Ranking[i] = sum/this.value;
		}
		
		System.out.println("\n\nMa tran bien doi:");
		OutMatix(MatrixB);
		
		//Ranking Vecto
		
		System.out.println("Ranking Vecto:");
		OutMatrix(Ranking);
		
		float[] Weight =  new float[this.value];
		for(int i=0;i<this.value;i++)
		{
			float sum = 0;
			for(int j=0;j<this.value;j++)
			{
				sum+= this.arr[i][j]*Ranking[j];
			}
			Weight[i] = sum;
		}
		
		System.out.println("\n\nVecto trong so:");
		OutMatrix(Weight);
		
		
		float[] D =  new float[this.value];
		
		for(int i=0;i<this.value;i++)
		{
			D[i] = Weight[i] / Ranking[i];
		}
		
		System.out.println("\n\nVecto nhat quan:");
		OutMatrix(D);
		
		
		float lamda = 0;
		for(int i=0;i<this.value;i++)
		{
			lamda+=D[i];
		}
		lamda = lamda/this.value;
		float CL = (lamda - this.value)/(this.value-1);
		
		float CR = 0;
		if(this.value == 3) CR = CL/(float)0.58;
		else if(this.value == 4) CR = CL/(float)0.9;
		else if(this.value ==5) CR = CL/(float)1.12;
		System.out.println("lamda\t   CL\t\tCR");
		System.out.println(lamda +" "+ CL + " "+ CR);
		
		
		
		return Ranking;
	}

}
