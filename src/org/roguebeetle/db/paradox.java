// Классс просмотра базы данных paradox

package org.roguebeetle.db;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class paradox {

    public List<String> AddressData = new ArrayList<>();
    public List<String> Data = new ArrayList<>();

    Connection c = null;
    Statement stmt = null;

    public void selectParadoxB00001(){
        try {
            Class.forName("com.googlecode.paradox.Driver");
            c = DriverManager.getConnection("jdbc:paradox:db/paradox");
            c.setAutoCommit(false);
            System.out.println("Открылись для выборки");

            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM B00001.db" )) {
                while ( rs.next()) {
                    String ID  = new String(String.valueOf(rs.getString("ID")).getBytes("ISO-8859-1"), "cp1251");
                    String N_dinam = new String(String.valueOf(rs.getString("N_dinam")).getBytes("ISO-8859-1"), "cp1251");
                    String Adres_Doma  = new String(String.valueOf(rs.getString("Adres_Doma")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_Doma   = new String(String.valueOf(rs.getString("Num_Doma")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_korp = new String(String.valueOf(rs.getString("Num_korp")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_Jeu = new String(String.valueOf(rs.getString("Num_Jeu")).getBytes("ISO-8859-1"), "cp1251");
                    String Sistema = new String(String.valueOf(rs.getString("Sistema")).getBytes("ISO-8859-1"), "cp1251");
                    String IMG_GVS = new String(String.valueOf(rs.getString("IMG_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String IMG_OT = new String(String.valueOf(rs.getString("IMG_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String a_snyat   = new String(String.valueOf(rs.getString("a_snyat")).getBytes("ISO-8859-1"), "cp1251");
                    String a_otvezen   = new String(String.valueOf(rs.getString("a_otvezen")).getBytes("ISO-8859-1"), "cp1251");
                    String a_Privesen   = new String(String.valueOf(rs.getString("a_Privesen")).getBytes("ISO-8859-1"), "cp1251");
                    String a_Postavlen   = new String(String.valueOf(rs.getString("a_Postavlen")).getBytes("ISO-8859-1"), "cp1251");
                    String Marka_Pribor   = new String(String.valueOf(rs.getString("Marka_Pribor")).getBytes("ISO-8859-1"), "cp1251");
                    String Naim_Podr  = new String(String.valueOf(rs.getString("Naim_Podr")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Vipuska_IVB  = new String(String.valueOf(rs.getString("Data_Vipuska_IVB")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Ustanovki  = new String(String.valueOf(rs.getString("Data_Ustanovki")).getBytes("ISO-8859-1"), "cp1251");
                    String Shema  = new String(String.valueOf(rs.getString("Shema")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_IVB  = new String(String.valueOf(rs.getString("Num_IVB")).getBytes("ISO-8859-1"), "cp1251");
                    String Typ_PPR  = new String(String.valueOf(rs.getString("Typ_PPR")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_PPR1  = new String(String.valueOf(rs.getString("Num_PPR1")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_PPR2  = new String(String.valueOf(rs.getString("Num_PPR2")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_PPR3  = new String(String.valueOf(rs.getString("Num_PPR3")).getBytes("ISO-8859-1"), "cp1251");
                    String Diam_1  = new String(String.valueOf(rs.getString("Diam_1")).getBytes("ISO-8859-1"), "cp1251");
                    String Diam_2  = new String(String.valueOf(rs.getString("Diam_2")).getBytes("ISO-8859-1"), "cp1251");
                    String Diam_3  = new String(String.valueOf(rs.getString("Diam_3")).getBytes("ISO-8859-1"), "cp1251");
                    String TYP_TSP_GVS  = new String(String.valueOf(rs.getString("TYP_TSP_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String TYP_TSP_OT  = new String(String.valueOf(rs.getString("TYP_TSP_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_TSP1  = new String(String.valueOf(rs.getString("Num_TSP1")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_TSP2  = new String(String.valueOf(rs.getString("Num_TSP2")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_TSP3  = new String(String.valueOf(rs.getString("Num_TSP3")).getBytes("ISO-8859-1"), "cp1251");
                    String XV_prog  = new String(String.valueOf(rs.getString("XV_prog")).getBytes("ISO-8859-1"), "cp1251");
                    String prog_XV  = new String(String.valueOf(rs.getString("prog_XV")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_TSP4  = new String(String.valueOf(rs.getString("Num_TSP4")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_TSP5  = new String(String.valueOf(rs.getString("Num_TSP5")).getBytes("ISO-8859-1"), "cp1251");
                    String Diap_GVS  = new String(String.valueOf(rs.getString("Diap_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Diap_OT  = new String(String.valueOf(rs.getString("Diap_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Status_GVS  = new String(String.valueOf(rs.getString("Status_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Status_OT  = new String(String.valueOf(rs.getString("Status_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Post_Uch_GVS  = new String(String.valueOf(rs.getString("Data_Post_Uch_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Sn_Uch_GVS  = new String(String.valueOf(rs.getString("Data_Sn_Uch_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Post_Uch_OT  = new String(String.valueOf(rs.getString("Data_Post_Uch_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Sn_Uch_OT  = new String(String.valueOf(rs.getString("Data_Sn_Uch_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Poverki_IVB  = new String(String.valueOf(rs.getString("Data_Poverki_IVB")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Sled_Poverki_IVB  = new String(String.valueOf(rs.getString("Data_Sled_Poverki_IVB")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Poverki_RSM  = new String(String.valueOf(rs.getString("Data_Poverki_RSM")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Sled_Poverki_RSM  = new String(String.valueOf(rs.getString("Data_Sled_Poverki_RSM")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_SN_Poverka  = new String(String.valueOf(rs.getString("Data_SN_Poverka")).getBytes("ISO-8859-1"), "cp1251");
                    String Data_Privoza_S_Poverki  = new String(String.valueOf(rs.getString("Data_Privoza_S_Poverki")).getBytes("ISO-8859-1"), "cp1251");
                    String Naim_poveritelya  = new String(String.valueOf(rs.getString("Naim_poveritelya")).getBytes("ISO-8859-1"), "cp1251");
                    String Status_Poverki  = new String(String.valueOf(rs.getString("Status_Poverki")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_REG_OT  = new String(String.valueOf(rs.getString("Num_REG_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_REG_GVS  = new String(String.valueOf(rs.getString("Num_REG_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Ploschad_Doma  = new String(String.valueOf(rs.getString("Ploschad_Doma")).getBytes("ISO-8859-1"), "cp1251");
                    String Kol_Jilcov  = new String(String.valueOf(rs.getString("Kol_Jilcov")).getBytes("ISO-8859-1"), "cp1251");
                    String Kol_kvartir  = new String(String.valueOf(rs.getString("Kol_kvartir")).getBytes("ISO-8859-1"), "cp1251");
                    String Kommentarii  = new String(String.valueOf(rs.getString("Kommentarii")).getBytes("ISO-8859-1"), "cp1251");
                    String Select_Dom  = new String(String.valueOf(rs.getString("Select_Dom")).getBytes("ISO-8859-1"), "cp1251");
                    String Pr_Q_GVS  = new String(String.valueOf(rs.getString("Pr_Q_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Pr_V_GVS = new String(String.valueOf(rs.getString("Pr_V_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Pr_Q_OT  = new String(String.valueOf(rs.getString("Pr_Q_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Pr_V_OT  = new String(String.valueOf(rs.getString("Pr_V_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String POVERKA_TSP_GVS  = new String(String.valueOf(rs.getString("POVERKA_TSP_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String SL_POVERKA_TSP_GVS  = new String(String.valueOf(rs.getString("SL_POVERKA_TSP_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String POVERKA_TSP_OT  = new String(String.valueOf(rs.getString("POVERKA_TSP_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String SL_POVERKA_TSP_OT  = new String(String.valueOf(rs.getString("SL_POVERKA_TSP_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Mgnov_proekt_GVS  = new String(String.valueOf(rs.getString("Mgnov_proekt_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Mgnov_proekt_OT  = new String(String.valueOf(rs.getString("Mgnov_proekt_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Mgnov_BERN_GVS  = new String(String.valueOf(rs.getString("Mgnov_BERN_GVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Mgnov_BERN_OT  = new String(String.valueOf(rs.getString("Mgnov_BERN_OT")).getBytes("ISO-8859-1"), "cp1251");
                    String Num_INVENT  = new String(String.valueOf(rs.getString("Num_INVENT")).getBytes("ISO-8859-1"), "cp1251");
                    String Period_IVB  = new String(String.valueOf(rs.getString("Period_IVB")).getBytes("ISO-8859-1"), "cp1251");
                    String Period_TSPGVS  = new String(String.valueOf(rs.getString("Period_TSPGVS")).getBytes("ISO-8859-1"), "cp1251");
                    String Period_TSPOT  = new String(String.valueOf(rs.getString("Period_TSPOT")).getBytes("ISO-8859-1"), "cp1251");
                    String Period_RSM  = new String(String.valueOf(rs.getString("Period_RSM")).getBytes("ISO-8859-1"), "cp1251");
                    String Etalon  = new String(String.valueOf(rs.getString("Etalon")).getBytes("ISO-8859-1"), "cp1251");
                    String Seriya  = new String(String.valueOf(rs.getString("Seriya")).getBytes("ISO-8859-1"), "cp1251");
                    String Tepov_Nagr  = new String(String.valueOf(rs.getString("Tepov_Nagr")).getBytes("ISO-8859-1"), "cp1251");
                    String Teplov_Nagr1  = new String(String.valueOf(rs.getString("Teplov_Nagr1")).getBytes("ISO-8859-1"), "cp1251");
                    String SIM1  = new String(String.valueOf(rs.getString("SIM1")).getBytes("ISO-8859-1"), "cp1251");
                    String SIM2  = new String(String.valueOf(rs.getString("SIM2")).getBytes("ISO-8859-1"), "cp1251");
                    String SIM3  = new String(String.valueOf(rs.getString("SIM3")).getBytes("ISO-8859-1"), "cp1251");

                    System.out.print(ID+" ");
                    System.out.print(N_dinam+" ");
                    System.out.print(Adres_Doma+" ");
                    System.out.print(Num_Doma+" ");
                    System.out.print(Num_korp+" ");
                    System.out.print(Num_Jeu+" ");
                    System.out.print(Sistema+" ");
                    System.out.print(IMG_GVS+" ");
                    System.out.print(IMG_OT+" ");
                    System.out.print(a_snyat+" ");
                    System.out.print(a_otvezen+" ");
                    System.out.print(a_Privesen+" ");
                    System.out.print(a_Postavlen+" ");
                    System.out.print(Marka_Pribor+" ");
                    System.out.print(Naim_Podr+" ");
                    System.out.print(Data_Vipuska_IVB+" ");
                    System.out.print(Data_Ustanovki+" ");
                    System.out.print(Shema+" ");
                    System.out.print(Num_IVB+" ");
                    System.out.print(Typ_PPR+" ");
                    System.out.print(Num_PPR1+" ");
                    System.out.print(Num_PPR2+" ");
                    System.out.print(Num_PPR3+" ");
                    System.out.print(Diam_1+" ");
                    System.out.print(Diam_2+" ");
                    System.out.print(Diam_3+" ");
                    System.out.print(TYP_TSP_GVS+" ");
                    System.out.print(TYP_TSP_OT+" ");
                    System.out.print(Num_TSP1+" ");
                    System.out.print(Num_TSP2+" ");
                    System.out.print(Num_TSP3+" ");
                    System.out.print(XV_prog+" ");
                    System.out.print(prog_XV+" ");
                    System.out.print(Num_TSP4+" ");
                    System.out.print(Num_TSP5+" ");
                    System.out.print(Diap_GVS+" ");
                    System.out.print(Diap_OT+" ");
                    System.out.print(Status_GVS+" ");
                    System.out.print(Status_OT+" ");
                    System.out.print(Data_Post_Uch_GVS+" ");
                    System.out.print(Data_Sn_Uch_GVS+" ");
                    System.out.print(Data_Post_Uch_OT+" ");
                    System.out.print(Data_Sn_Uch_OT+" ");
                    System.out.print(Data_Poverki_IVB+" ");
                    System.out.print(Data_Sled_Poverki_IVB+" ");
                    System.out.print(Data_Poverki_RSM+" ");
                    System.out.print(Data_Sled_Poverki_RSM+" ");
                    System.out.print(Data_SN_Poverka+" ");
                    System.out.print(Data_Privoza_S_Poverki+" ");
                    System.out.print(Naim_poveritelya+" ");
                    System.out.print(Status_Poverki+" ");
                    System.out.print(Num_REG_OT+" ");
                    System.out.print(Num_REG_GVS+" ");
                    System.out.print(Ploschad_Doma+" ");
                    System.out.print(Kol_Jilcov+" ");
                    System.out.print(Kol_kvartir+" ");
                    System.out.print(Kommentarii+" ");
                    System.out.print(Select_Dom+" ");
                    System.out.print(Pr_Q_GVS+" ");
                    System.out.print(Pr_V_GVS+" ");
                    System.out.print(Pr_Q_OT+" ");
                    System.out.print(Pr_V_OT+" ");
                    System.out.print(POVERKA_TSP_GVS+" ");
                    System.out.print(SL_POVERKA_TSP_GVS+" ");
                    System.out.print(POVERKA_TSP_OT+" ");
                    System.out.print(SL_POVERKA_TSP_OT+" ");
                    System.out.print(Mgnov_proekt_GVS+" ");
                    System.out.print(Mgnov_proekt_OT+" ");
                    System.out.print(Mgnov_BERN_GVS+" ");
                    System.out.print(Mgnov_BERN_OT+" ");
                    System.out.print(Num_INVENT+" ");
                    System.out.print(Period_IVB+" ");
                    System.out.print(Period_TSPGVS+" ");
                    System.out.print(Period_TSPOT+" ");
                    System.out.print(Period_RSM+" ");
                    System.out.print(Etalon+" ");
                    System.out.print(Seriya+" ");
                    System.out.print(Tepov_Nagr+" ");
                    System.out.print(Teplov_Nagr1+" ");
                    System.out.print(SIM1+" ");
                    System.out.print(SIM2+" ");
                    System.out.print(SIM3+" ");

                }
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException | UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Выборка прокатила");
    }                     // Просмотр таблицы с данными на приборы
    public void selectParadoxB00003(){
        try {
            Class.forName("com.googlecode.paradox.Driver");
            c = DriverManager.getConnection("jdbc:paradox:db/paradox");
            c.setAutoCommit(true);
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM B00003.db" )) { //WHERE ID > '90000'
                Object nihuya = null;
                while (rs.next()) {
                    String ID   = new String(String.valueOf(rs.getString("ID")).getBytes("ISO-8859-1"), "cp1251");
                    String id   = new String(String.valueOf(rs.getString("Num_Pribor")).getBytes("ISO-8859-1"), "cp1251");
                    String ss   = new String(String.valueOf(rs.getString("Har_sistem")).getBytes("ISO-8859-1"), "cp1251");
                    String dp   = new String(String.valueOf(rs.getString("Data_pokaz")).getBytes("ISO-8859-1"), "cp1251");
                    String vp   = new String(String.valueOf(rs.getString("Vremya_pokaz")).getBytes("ISO-8859-1"), "cp1251");
                    String q1   = new String(String.valueOf(rs.getString("Qpod")).getBytes("ISO-8859-1"), "cp1251");
                    String q2   = new String(String.valueOf(rs.getString("Qobr")).getBytes("ISO-8859-1"), "cp1251");
                    String v1   = new String(String.valueOf(rs.getString("Vpod")).getBytes("ISO-8859-1"), "cp1251");
                    String v2   = new String(String.valueOf(rs.getString("Vobr")).getBytes("ISO-8859-1"), "cp1251");
                    String g1   = new String(String.valueOf(rs.getString("Gpod")).getBytes("ISO-8859-1"), "cp1251");
                    String g2   = new String(String.valueOf(rs.getString("Gobr")).getBytes("ISO-8859-1"), "cp1251");
                    String t1   = new String(String.valueOf(rs.getString("Tpod")).getBytes("ISO-8859-1"), "cp1251");
                    String t2   = new String(String.valueOf(rs.getString("Tobr")).getBytes("ISO-8859-1"), "cp1251");
                    String t3   = new String(String.valueOf(rs.getString("TXV")).getBytes("ISO-8859-1"), "cp1251");
                    String tw   = new String(String.valueOf(rs.getString("Traboti")).getBytes("ISO-8859-1"), "cp1251");

                    System.out.print( "ID: "        + ID + " ");
                    System.out.print( "Номер ИВБ: " + id + " ");
                    System.out.print( "Система: "   + ss + " ");
                    System.out.print( "Дата: "      + dp + " ");
                    System.out.print( "Время: "     + vp + " ");
                    System.out.print( "Q1: "        + q1 + " ");
                    System.out.print( "Q2: "        + q2 + " ");
                    System.out.print( "V1: "        + v1 + " ");
                    System.out.print( "V2: "        + v2 + " ");
                    System.out.print( "G1: "        + g1 + " ");
                    System.out.print( "G2: "        + g2 + " ");
                    System.out.print( "T1: "        + t1 + " ");
                    System.out.print( "T2: "        + t2 + " ");
                    System.out.print( "T3: "        + t3 + " ");
                    System.out.print( "Время Работы: " + tw + "\n");
                }
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException | UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Выборка прокатила");
    };
    public void printAddressList() {
        int i = 0;
        while (i != AddressData.size()) {
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " ");
            i++;
            System.out.print(AddressData.get(i) + " \n");
            i++;
        }

    }                       // Просмотр временного массива адресов
    public void printDataList() {
        int i = 0;
        while (i != Data.size()) {
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " ");
            i++;
            System.out.print(Data.get(i) + " \n");
            i++;
        }

    }                          // Просмотр временного массива показаний
}
