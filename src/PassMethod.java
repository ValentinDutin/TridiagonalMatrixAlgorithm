public class PassMethod {
    private double vectorA[];
    private double vectorC[];
    private double vectorB[];
    private double vectorF[];
    private double vectorX[];
    private double vectorAlpha[];
    private double vectorBeta[];
    private double discrepancy[];
    private int n;
    private double det;

    PassMethod(double matrA[][], double vectorD[]){
        n = matrA.length;
        vectorA = new double[n];
        vectorC = new double[n];
        vectorB = new double[n-1];
        vectorF = new double[n];
        vectorC[0] = matrA[0][0];
        vectorB[0] = -matrA[0][1];
        vectorF[0] = vectorD[0];
        for(int i = 1; i < n-1; i++){
            vectorA[i] = -matrA[i][i-1];
            vectorC[i] = matrA[i][i];
            vectorB[i] = -matrA[i][i+1];
            vectorF[i] = vectorD[i];
        }
        vectorC[n-1] = matrA[n-1][n-1];
        vectorA[n-1] = -matrA[n-1][n-2];
        vectorF[n-1] = vectorD[n-1];
    }

    public void passMethod(){
        vectorAlpha = new double[n];
        vectorBeta = new double[n+1];
        vectorAlpha[0] = vectorB[0] / vectorC[0];
        vectorBeta[0] = vectorF[0] / vectorC[0];
        for(int i = 1; i < n + 1; i++){
            if(i < n) {
                vectorAlpha[i] = vectorB[i - 1] / (vectorC[i - 1] - vectorAlpha[i - 1] * vectorA[i - 1]);
            }
                vectorBeta[i] = (vectorF[i-1] + vectorBeta[i-1]*vectorA[i-1]) / (vectorC[i-1] - vectorAlpha[i-1]*vectorA[i-1]);
        }
    }

    public void createVectorX(){
        vectorX = new double[n];
        vectorX[n-1] = vectorBeta[n];
        for(int i = n-2; i >= 0; i--){
            vectorX[i] = vectorAlpha[i+1]*vectorX[i+1] + vectorBeta[i+1];
        }
    }

    public void createDiscrepancy(double matrA[][], double vectorB[]){
        discrepancy = new double[n];
        double[] res = new double[n];
        for(int i = 0; i < n; i++){
            res[i] = 0;
            for(int j = 0; j < n; j++){
                res[i] += matrA[i][j]*vectorX[j];
            }
            discrepancy[i] = vectorB[i] - res[i];
        }
    }
    public void createDet(){
        det = vectorC[0];
        for(int i = 1; i < n; i++){
            det *= (vectorC[i] - vectorAlpha[i]*vectorA[i]);
        }
    }

    public void printDet(){
        System.out.println("\nDet = " + det);
    }

    public void printVectorX(){
        System.out.println("vector X");
        for(double item: vectorX){
            System.out.format("%25s", item + "    ");
        }
        System.out.println("\n");
    }

    public void printDiscrepancy(){
        System.out.println("Discrepancy");
        for(double item: discrepancy){
            System.out.format("%25s", item + "    ");
        }
        System.out.println();
    }



}
