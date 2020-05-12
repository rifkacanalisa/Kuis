public class Penilaian {
    private int tulis,coding,wawancara,nilai4,nilaiAkhir;
    private String status;
     public Penilaian(int nilaiTulis, int nilaiCoding, int nilaiWawancara,int nilai4){
         tulis = nilaiTulis;
         coding = nilaiCoding;
         wawancara = nilaiWawancara;
         this.nilai4 = nilai4;
         if(tulis<0 || coding<0 || wawancara<0 || this.nilai4<0){
             throw new IllegalArgumentException("Nilai yang diinput tidak boleh negatif");
         }
     }
    public int hitungNilaiAkhir(){
        nilaiAkhir = (tulis+coding+wawancara+nilai4)/4;
        return nilaiAkhir;
    }

    public String statusSeleksi(int nilaiAkhir){
        if(nilaiAkhir>85){
            status="LOLOS";
            return status;
        }
        else{
            status="GAGAL";
            return status;
        }
    }
}
