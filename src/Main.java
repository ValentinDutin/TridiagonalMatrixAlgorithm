public class Main {
    public static void main(String[] args) {
        try {
            double matrA[][] = {
                    {0.5757, -0.0758, 0.0000,  0.0000,  0.0000},
                    {0.0788,  0.9014, 0.0000,  0.0000,  0.0000},
                    {0.0000,  0.0000, 0.7242, -0.2121,  0.0000},
                    {0.0000,  0.0000, 0.0000,  0.7121, -0.0303},
                    {0.0000,  0.0000, 0.0000,  0.0152,  0.8484}
            };
            double vectorB[] = {
                     3.5148,
                     3.8542,
                    -4.9056,
                     2.3240,
                     0.1818
            };
            PassMethod ps = new PassMethod(matrA, vectorB);
            ps.passMethod();
            ps.createVectorX();
            ps.printVectorX();
            ps.createDiscrepancy(matrA, vectorB);
            ps.printDiscrepancy();
            ps.createDet();
            ps.printDet();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
