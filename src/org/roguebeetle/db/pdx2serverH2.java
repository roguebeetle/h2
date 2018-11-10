// Класс импорта таблиц paradox на сервер H2

package org.roguebeetle.db;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class pdx2serverH2 {
    //Глобальные структуры и переменные
    public List<String> AddressData = new ArrayList<>();
    public List<String> Data = new ArrayList<>();

    Connection c = null;
    Statement stmt = null;
    String ConUrl = "jdbc:h2:tcp://localhost/~/kip";
    String User = "SA";
    String Pass = "";
    /////////////////////////////
//Рабочие методы
    public void createH2Tables() {
        try {
            Class.forName("org.h2.Driver");
            c = DriverManager.getConnection(ConUrl, User, Pass);
            System.out.println("Create началось заебись");

            stmt = c.createStatement();
            String sql = "CREATE TABLE objects " +
                    "(id INT PRIMARY KEY NOT NULL," +
                    " N_dinam TEXT, " +
                    " Adres_Doma TEXT, " +
                    " Num_Doma TEXT, " +
                    " Num_korp TEXT, " +
                    " Num_Jeu TEXT, " +
                    " Sistema TEXT, " +
                    " IMG_GVS TEXT, " +
                    " IMG_OT TEXT, " +
                    " a_snyat TEXT, " +
                    " a_otvezen TEXT, " +
                    " a_Privesen TEXT, " +
                    " a_Postavlen TEXT, " +
                    " Marka_Pribor TEXT, " +
                    " Naim_Podr TEXT, " +
                    " Data_Vipuska_IVB TEXT, " +
                    " Data_Ustanovki TEXT, " +
                    " Shema TEXT, " +
                    " Num_IVB TEXT, " +
                    " Typ_PPR TEXT, " +
                    " Num_PPR1 TEXT, " +
                    " Num_PPR2 TEXT, " +
                    " Num_PPR3 TEXT, " +
                    " Diam_1 TEXT, " +
                    " Diam_2 TEXT, " +
                    " Diam_3 TEXT, " +
                    " TYP_TSP_GVS TEXT, " +
                    " TYP_TSP_OT TEXT, " +
                    " Num_TSP1 TEXT, " +
                    " Num_TSP2 TEXT, " +
                    " Num_TSP3 TEXT, " +
                    " XV_prog TEXT, " +
                    " prog_XV TEXT, " +
                    " Num_TSP4 TEXT, " +
                    " Num_TSP5 TEXT, " +
                    " Diap_GVS TEXT, " +
                    " Diap_OT TEXT, " +
                    " Status_GVS TEXT, " +
                    " Status_OT TEXT, " +
                    " Data_Post_Uch_GVS TEXT, " +
                    " Data_Sn_Uch_GVS TEXT, " +
                    " Data_Post_Uch_OT TEXT, " +
                    " Data_Sn_Uch_OT TEXT, " +
                    " Data_Poverki_IVB TEXT, " +
                    " Data_Sled_Poverki_IVB TEXT, " +
                    " Data_Poverki_RSM TEXT, " +
                    " Data_Sled_Poverki_RSM TEXT, " +
                    " Data_SN_Poverka TEXT, " +
                    " Data_Privoza_S_Poverki TEXT, " +
                    " Naim_poveritelya TEXT, " +
                    " Status_Poverki TEXT, " +
                    " Num_REG_OT TEXT, " +
                    " Num_REG_GVS TEXT, " +
                    " Ploschad_Doma TEXT, " +
                    " Kol_Jilcov TEXT, " +
                    " Kol_kvartir TEXT, " +
                    " Kommentarii TEXT, " +
                    " Select_Dom TEXT, " +
                    " Pr_Q_GVS TEXT, " +
                    " Pr_V_GVS TEXT, " +
                    " Pr_Q_OT TEXT, " +
                    " Pr_V_OT TEXT, " +
                    " POVERKA_TSP_GVS TEXT, " +
                    " SL_POVERKA_TSP_GVS TEXT, " +
                    " POVERKA_TSP_OT TEXT, " +
                    " SL_POVERKA_TSP_OT TEXT, " +
                    " Mgnov_proekt_GVS TEXT, " +
                    " Mgnov_proekt_OT TEXT, " +
                    " Mgnov_BERN_GVS TEXT, " +
                    " Mgnov_BERN_OT TEXT, " +
                    " Num_INVENT TEXT, " +
                    " Period_IVB TEXT, " +
                    " Period_TSPGVS TEXT, " +
                    " Period_TSPOT TEXT, " +
                    " Period_RSM TEXT, " +
                    " Etalon TEXT, " +
                    " Seriya TEXT, " +
                    " Tepov_Nagr TEXT, " +
                    " Teplov_Nagr1 TEXT, " +
                    " SIM1 TEXT, " +
                    " SIM2 TEXT, " +
                    " SIM3 TEXT)";
            stmt.executeUpdate(sql);
            String sql2 = "CREATE TABLE data " +
                    "(id INT PRIMARY KEY  NOT NULL," +
                    " ivb            TEXT NOT NULL, " +
                    " system         TEXT NOT NULL, " +
                    " date           TEXT, " +
                    " time           TEXT NOT NULL, " +
                    " q1             TEXT NOT NULL, " +
                    " q2             TEXT, " +
                    " v1             TEXT NOT NULL, " +
                    " v2             TEXT, " +
                    " g1             TEXT NOT NULL, " +
                    " g2             TEXT, " +
                    " t1             TEXT NOT NULL, " +
                    " t2             TEXT, " +
                    " t3             TEXT, " +
                    " tw             TEXT)";
            stmt.executeUpdate(sql2);

            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Таблица создана");
    }                           // Создание таблиц Objects(Приборы) Data(Показания) в базе SQLite
    public void cloneParadoxAddressDataToList(){
        try {
            Class.forName("com.googlecode.paradox.Driver");
            c = DriverManager.getConnection("jdbc:paradox:db/paradox");
            c.setAutoCommit(false);
            System.out.println("Копируем объекты в память: ");
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM B00001.db" )) {
                while (rs.next()) {
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
                    String Num_PPR1  = new String(String.valueOf(rs.getString("Num_PPR1")));
                    String Num_PPR2  = new String(String.valueOf(rs.getString("Num_PPR2")));
                    String Num_PPR3  = new String(String.valueOf(rs.getString("Num_PPR3")));
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
                    AddressData.add(ID);
                    AddressData.add(N_dinam);
                    AddressData.add(Adres_Doma);
                    AddressData.add(Num_Doma);
                    AddressData.add(Num_korp);
                    AddressData.add(Num_Jeu);
                    AddressData.add(Sistema);
                    AddressData.add(IMG_GVS);
                    AddressData.add(IMG_OT);
                    AddressData.add(a_snyat);
                    AddressData.add(a_otvezen);
                    AddressData.add(a_Privesen);
                    AddressData.add(a_Postavlen);
                    AddressData.add(Marka_Pribor);
                    AddressData.add(Naim_Podr);
                    AddressData.add(Data_Vipuska_IVB);
                    AddressData.add(Data_Ustanovki);
                    AddressData.add(Shema);
                    AddressData.add(Num_IVB);
                    AddressData.add(Typ_PPR);
                    AddressData.add(Num_PPR1);
                    AddressData.add(Num_PPR2);
                    AddressData.add(Num_PPR3);
                    AddressData.add(Diam_1);
                    AddressData.add(Diam_2);
                    AddressData.add(Diam_3);
                    AddressData.add(TYP_TSP_GVS);
                    AddressData.add(TYP_TSP_OT);
                    AddressData.add(Num_TSP1);
                    AddressData.add(Num_TSP2);
                    AddressData.add(Num_TSP3);
                    AddressData.add(XV_prog);
                    AddressData.add(prog_XV);
                    AddressData.add(Num_TSP4);
                    AddressData.add(Num_TSP5);
                    AddressData.add(Diap_GVS);
                    AddressData.add(Diap_OT);
                    AddressData.add(Status_GVS);
                    AddressData.add(Status_OT);
                    AddressData.add(Data_Post_Uch_GVS);
                    AddressData.add(Data_Sn_Uch_GVS);
                    AddressData.add(Data_Post_Uch_OT);
                    AddressData.add(Data_Sn_Uch_OT);
                    AddressData.add(Data_Poverki_IVB);
                    AddressData.add(Data_Sled_Poverki_IVB);
                    AddressData.add(Data_Poverki_RSM);
                    AddressData.add(Data_Sled_Poverki_RSM);
                    AddressData.add(Data_SN_Poverka);
                    AddressData.add(Data_Privoza_S_Poverki);
                    AddressData.add(Naim_poveritelya);
                    AddressData.add(Status_Poverki);
                    AddressData.add(Num_REG_OT);
                    AddressData.add(Num_REG_GVS);
                    AddressData.add(Ploschad_Doma);
                    AddressData.add(Kol_Jilcov);
                    AddressData.add(Kol_kvartir);
                    AddressData.add(Kommentarii);
                    AddressData.add(Select_Dom);
                    AddressData.add(Pr_Q_GVS);
                    AddressData.add(Pr_V_GVS);
                    AddressData.add(Pr_Q_OT);
                    AddressData.add(Pr_V_OT);
                    AddressData.add(POVERKA_TSP_GVS);
                    AddressData.add(SL_POVERKA_TSP_GVS);
                    AddressData.add(POVERKA_TSP_OT);
                    AddressData.add(SL_POVERKA_TSP_OT);
                    AddressData.add(Mgnov_proekt_GVS);
                    AddressData.add(Mgnov_proekt_OT);
                    AddressData.add(Mgnov_BERN_GVS);
                    AddressData.add(Mgnov_BERN_OT);
                    AddressData.add(Num_INVENT);
                    AddressData.add(Period_IVB);
                    AddressData.add(Period_TSPGVS);
                    AddressData.add(Period_TSPOT);
                    AddressData.add(Period_RSM);
                    AddressData.add(Etalon);
                    AddressData.add(Seriya);
                    AddressData.add(Tepov_Nagr);
                    AddressData.add(Teplov_Nagr1);
                    AddressData.add(SIM1);
                    AddressData.add(SIM2);
                    AddressData.add(SIM3);
                }
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException | UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Копирование объектов в память завершено.");
    }             // Копирование таблицы с описанием приборов из базы Paradox во временный массив
    public void cloneAddressDataToH2Objects(){
        try {
            Class.forName("org.h2.Driver");
            c = DriverManager.getConnection(ConUrl, User, Pass);
            c.setAutoCommit(false);
            System.out.println("Вставляем объекты из памяти в H2 БД:");
            stmt = c.createStatement();
            int y=1;
            for (int i=0; i<=AddressData.size()-2; ++i) {
                String sql =
                        "INSERT INTO objects (ID,N_dinam,Adres_Doma,Num_Doma,Num_korp,Num_Jeu,Sistema,IMG_GVS,IMG_OT," +
                                "a_snyat,a_otvezen,a_Privesen,a_Postavlen,Marka_Pribor,Naim_Podr,Data_Vipuska_IVB," +
                                "Data_Ustanovki,Shema,Num_IVB,Typ_PPR,Num_PPR1,Num_PPR2,Num_PPR3,Diam_1,Diam_2,Diam_3," +
                                "TYP_TSP_GVS,TYP_TSP_OT,Num_TSP1,Num_TSP2,Num_TSP3,XV_prog,prog_XV,Num_TSP4,Num_TSP5," +
                                "Diap_GVS,Diap_OT,Status_GVS, Status_OT, Data_Post_Uch_GVS,Data_Sn_Uch_GVS,Data_Post_Uch_OT,Data_Sn_Uch_OT," +
                                "Data_Poverki_IVB,Data_Sled_Poverki_IVB,Data_Poverki_RSM,Data_Sled_Poverki_RSM," +
                                "Data_SN_Poverka,Data_Privoza_S_Poverki,Naim_poveritelya,Status_Poverki,Num_REG_OT," +
                                "Num_REG_GVS,Ploschad_Doma,Kol_Jilcov,Kol_kvartir,Kommentarii,Select_Dom,Pr_Q_GVS," +
                                "Pr_V_GVS,Pr_Q_OT,Pr_V_OT,POVERKA_TSP_GVS,SL_POVERKA_TSP_GVS,POVERKA_TSP_OT," +
                                "SL_POVERKA_TSP_OT,Mgnov_proekt_GVS,Mgnov_proekt_OT,Mgnov_BERN_GVS,Mgnov_BERN_OT," +
                                "Num_INVENT,Period_IVB,Period_TSPGVS,Period_TSPOT,Period_RSM,Etalon,Seriya,Tepov_Nagr," +
                                "Teplov_Nagr1,SIM1,SIM2,SIM3) "+"VALUES("+(y)+"," +
                                "'"+AddressData.get(i+1) +"'," +
                                "'"+AddressData.get(i+2) +"'," +
                                "'"+AddressData.get(i+3) +"'," +
                                "'"+AddressData.get(i+4) +"'," +
                                "'"+AddressData.get(i+5) +"'," +
                                "'"+AddressData.get(i+6) +"'," +
                                "'"+AddressData.get(i+7) +"'," +
                                "'"+AddressData.get(i+8) +"'," +
                                "'"+AddressData.get(i+9) +"'," +
                                "'"+AddressData.get(i+10)+"'," +
                                "'"+AddressData.get(i+11)+"'," +
                                "'"+AddressData.get(i+12)+"'," +
                                "'"+AddressData.get(i+13)+"'," +
                                "'"+AddressData.get(i+14)+"'," +
                                "'"+AddressData.get(i+15)+"'," +
                                "'"+AddressData.get(i+16)+"'," +
                                "'"+AddressData.get(i+17)+"'," +
                                "'"+AddressData.get(i+18)+"'," +
                                "'"+AddressData.get(i+19)+"'," +
                                "'"+AddressData.get(i+20)+"'," +
                                "'"+AddressData.get(i+21)+"'," +
                                "'"+AddressData.get(i+22)+"'," +
                                "'"+AddressData.get(i+23)+"'," +
                                "'"+AddressData.get(i+24)+"'," +
                                "'"+AddressData.get(i+25)+"'," +
                                "'"+AddressData.get(i+26)+"'," +
                                "'"+AddressData.get(i+27)+"'," +
                                "'"+AddressData.get(i+28)+"'," +
                                "'"+AddressData.get(i+29)+"'," +
                                "'"+AddressData.get(i+30)+"'," +
                                "'"+AddressData.get(i+31)+"'," +
                                "'"+AddressData.get(i+32)+"'," +
                                "'"+AddressData.get(i+33)+"'," +
                                "'"+AddressData.get(i+34)+"'," +
                                "'"+AddressData.get(i+35)+"'," +
                                "'"+AddressData.get(i+36)+"'," +
                                "'"+AddressData.get(i+37)+"'," +
                                "'"+AddressData.get(i+38)+"'," +
                                "'"+AddressData.get(i+39)+"'," +
                                "'"+AddressData.get(i+40)+"'," +
                                "'"+AddressData.get(i+41)+"'," +
                                "'"+AddressData.get(i+42)+"'," +
                                "'"+AddressData.get(i+43)+"'," +
                                "'"+AddressData.get(i+44)+"'," +
                                "'"+AddressData.get(i+45)+"'," +
                                "'"+AddressData.get(i+46)+"'," +
                                "'"+AddressData.get(i+47)+"'," +
                                "'"+AddressData.get(i+48)+"'," +
                                "'"+AddressData.get(i+49)+"'," +
                                "'"+AddressData.get(i+50)+"'," +
                                "'"+AddressData.get(i+51)+"'," +
                                "'"+AddressData.get(i+52)+"'," +
                                "'"+AddressData.get(i+53)+"'," +
                                "'"+AddressData.get(i+54)+"'," +
                                "'"+AddressData.get(i+55)+"'," +
                                "'"+AddressData.get(i+56)+"'," +
                                "'"+AddressData.get(i+57)+"'," +
                                "'"+AddressData.get(i+58)+"'," +
                                "'"+AddressData.get(i+59)+"'," +
                                "'"+AddressData.get(i+60)+"'," +
                                "'"+AddressData.get(i+61)+"'," +
                                "'"+AddressData.get(i+62)+"'," +
                                "'"+AddressData.get(i+63)+"'," +
                                "'"+AddressData.get(i+64)+"'," +
                                "'"+AddressData.get(i+65)+"'," +
                                "'"+AddressData.get(i+66)+"'," +
                                "'"+AddressData.get(i+67)+"'," +
                                "'"+AddressData.get(i+68)+"'," +
                                "'"+AddressData.get(i+69)+"'," +
                                "'"+AddressData.get(i+70)+"'," +
                                "'"+AddressData.get(i+71)+"'," +
                                "'"+AddressData.get(i+72)+"'," +
                                "'"+AddressData.get(i+73)+"'," +
                                "'"+AddressData.get(i+74)+"'," +
                                "'"+AddressData.get(i+75)+"'," +
                                "'"+AddressData.get(i+76)+"'," +
                                "'"+AddressData.get(i+77)+"'," +
                                "'"+AddressData.get(i+78)+"'," +
                                "'"+AddressData.get(i+79)+"'," +
                                "'"+AddressData.get(i+80)+"'," +
                                "'"+AddressData.get(i+81)+"')";
                stmt.executeUpdate(sql);
                i=i+81;
                y++;
            }

            stmt.close();
            c.commit();
            c.close();
        } catch ( ClassNotFoundException | SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Вставка объектов в H2 БД завершена.");
    }               // Копирование таблицы с описанием приборов из временного массива в базу H2
    public void cloneParadoxDataToList(){
        try {
            Class.forName("com.googlecode.paradox.Driver");
            c = DriverManager.getConnection("jdbc:paradox:db/paradox/");
            c.setAutoCommit(false);
            System.out.println("Копируем показания в память: ");
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery( "SELECT * FROM B00003.db" )) {
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
                    Data.add(ID);
                    Data.add(id);
                    Data.add(ss);
                    Data.add(dp);
                    Data.add(vp);
                    Data.add(q1);
                    Data.add(q2);
                    Data.add(v1);
                    Data.add(v2);
                    Data.add(g1);
                    Data.add(g2);
                    Data.add(t1);
                    Data.add(t2);
                    Data.add(t3);
                    Data.add(tw);
                }
            }
            stmt.close();
            c.close();
        } catch ( ClassNotFoundException | SQLException | UnsupportedEncodingException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Показания скопированы в память.");
    }                    // Копирование таблицы с показаниями приборов из базы Paradox во временный массив
    public void cloneDataListToH2Objects(){
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(ConUrl, User, Pass);
            c.setAutoCommit(false);
            System.out.println("Вставляем показания из памяти в H2 БД:");
            stmt = c.createStatement();
            int y=1;
            for (int i=0; i<=Data.size()-2; ++i) {
                String sql = "INSERT INTO data (id,ivb,system,date,time,q1,q2,v1,v2,g1,g2,t1,t2,t3,tw) " +
                        "VALUES('"+(y)+"', '"+String.valueOf(Data.get(i+1))+"', '"+Data.get(i+2)+"', '"+Data.get(i+3)+"', '"
                               +Data.get(i+4)+"', '"+Data.get(i + 5)+"', '"+Data.get(i+6)+"', '"+Data.get(i+7)+"', '"
                               +Data.get(i+8)+"', '"+Data.get(i + 9)+"', '"+Data.get(i+10)+"', '"+Data.get(i+11)+"', '"
                               +Data.get(i+12)+"', '"+Data.get(i+13)+"', '"+Data.get(i+14)+"' );";
                stmt.executeUpdate(sql);
                i=i+14;
                y++;
            }

            stmt.close();
            c.commit();
            c.close();
        } catch ( ClassNotFoundException | SQLException e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Показания записаны в H2 БД.");
    }                  // Копирование таблицы с показаниями приборов из временного массива в базу H2
    //Удаление файла базы данных
    public void dbFileDel(){
        File file = new File("kip.db");
        file.delete();
    }

}
