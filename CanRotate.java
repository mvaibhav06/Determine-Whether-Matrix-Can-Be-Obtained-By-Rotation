class CanRotate {
    public int[][] rotate(int[][] mat){
        List<Integer> temp = new ArrayList<>();
        for(int i=0; i<mat.length; i++){
            for(int j=mat[i].length-1; j>=0; j--){
                temp.add(mat[j][i]);
            }
        }
        int k = 0;
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                mat[i][j] = temp.get(k++);
            }
            
        }
        return mat;
    }
    public boolean findRotation(int[][] mat, int[][] target) {
        // 00 01 10 11 -> 10 00 21 11
        // 00 01 02, 10 11 12, 20 21 22 -> 20 10 00, 21 11 01, 22 12 02
        for(int p=0; p<4; p++){
            mat = rotate(mat);
            int i = 0;
            for(i=0; i<mat.length; i++){
                int j = 0;
                for(j=0; j<mat.length; j++){
                    if(mat[i][j] != target[i][j]){
                        break;
                    }
                }
                if (j != mat.length){
                    break;
                }
            }
            if(i==mat.length){
                return true;
            }
        }
        return false;
    }
}
