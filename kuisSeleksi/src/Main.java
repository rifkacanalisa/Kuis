import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int banyak, menu;
        String jenis[] = {"Tertulis","Coding","Wawancara"};
        char lagi = 0;

        Scanner input = new Scanner(System.in);
        do{
            try{
                System.out.println("\n\tMENU FORM PENDAFTARAN");
                System.out.println("\t\t1. Asisten Lab");
                System.out.println("\t\t2. Admin Lab");
                System.out.print("\tPilihan : ");
                menu = input.nextInt();
                if(menu<=0){
                    throw new IllegalArgumentException("Menu dimulai dari angka 1");
                }
                else if(menu==1 || menu==2){
                    if(menu==1){ System.out.println("\t\tFORM PENDAFTARAN ASISTEN LAB\n"); }
                    else{ System.out.println("\t\tFORM PENDAFTARAN ADMIN LAB\n"); }
                    System.out.print("\tBanyak data yang ingin dimasukkan : ");
                    banyak = input.nextInt();
                    if(banyak<=0){ throw new IllegalArgumentException("Banyak data tidak boleh negatif"); }

                    String nama[] = new String[banyak];
                    String nim[] = new String[banyak];
                    int nilai[][] = new int[banyak][5];
                    String status[] = new String[banyak];
                    Penilaian mhs[] = new Penilaian[banyak];

                    for(int i=0; i<banyak; i++){
                        input.nextLine();
                        System.out.println("\n\tData "+(i+1));
                        System.out.print("\tMasukkan NIM\t:");
                        nim[i] = input.next(); input.nextLine();
                        System.out.print("\tMasukkan Nama\t:");
                        nama[i] = input.nextLine();
                        for(int j=0; j<3; j++){
                            System.out.print("\t\tMasukkan Nilai Tes "+jenis[j]+"\t:");
                            nilai[i][j] = input.nextInt();
                        }
                        if(menu==1){
                            System.out.print("\t\tMasukkan Nilai Tes Microteaching\t:");
                            nilai[i][3] = input.nextInt();
                        }
                        else{
                            System.out.print("\t\tMasukkan Nilai Tes Praktik Jaringan\t:");
                            nilai[i][3] = input.nextInt();
                        }
                        mhs[i] = new Penilaian(nilai[i][0],nilai[i][1],nilai[i][2],nilai[i][3]);
                        nilai[i][4] = mhs[i].hitungNilaiAkhir();
                        status[i] = mhs[i].statusSeleksi(nilai[i][4]);

                        System.out.println("\tNilai Akhir\t: "+nilai[i][4]);
                        System.out.println("\tKETERANGAN\t: "+status[i]);
                        if(status[i]=="LOLOS"){
                            if(menu==1){ System.out.println("\n\t /(^v^)/ Selamat kepada "+nim[i]+" telah diterima sebagai Asisten Lab");}
                            else{ System.out.println("\n\t /(^v^)/ Selamat kepada "+nim[i]+" telah diterima sebagai Admin Lab"); }
                        }
                        else{
                            if(menu==1){ System.out.println("\n\t (T^T) Mohon maaf kepada "+nim[i]+" telah ditolak menjadi Asisten Lab"); }
                            else{ System.out.println("\n\t (T^T) Mohon maaf kepada "+nim[i]+" telah ditolak menjadi Asisten Lab"); }
                        }
                    }
                }
                else{
                    throw new IllegalArgumentException("Menu tidak tersedia");
                }

                System.out.print("\nKembali ke menu utama? (y/n) :");
                lagi = input.next().charAt(0);
                System.out.println();
            } catch (InputMismatchException inputMismatchException){
                System.out.println("\nInput tidak sesuai dengan yang dibutuhkan");
                System.exit(1);
            } catch (IllegalArgumentException illegalArgumentException){
                System.out.println();
                System.out.println(illegalArgumentException.getMessage());
                System.exit(1);
            }
        } while (lagi=='y'||lagi=='Y');
    }
}
