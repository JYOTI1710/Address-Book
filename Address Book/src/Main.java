/**
 * Created by Personal on 11-11-2017.
 */

import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.lang.String;
import java.util.Vector;

public class Main
{
    public static void main(String [] args)
    {

        Addressbook i=new Addressbook();
    }
}

class Addressbook {
    JLabel fn, ln, pn, ad, UID, mail;
    JTextField tfn, tln, tpn, tad, TUID, tmail;
    JFrame f;
    Button addnew, search, View, delete;
    JLabel title = new JLabel( "JYOTI'S ADDRESS BOOK" );
    Addressbook( ) {


//**************ADD************\\
        addnew = new Button( "ADD NEW" );
        addnew.setBounds( 210, 100, 150, 50 );
        addnew.addActionListener( new ActionListener( ) {
            public void actionPerformed(ActionEvent e) { add();}});


//***********SEARCH************\\
        search = new Button( "SEARCH" );
        search.setBounds( 210, 200, 150, 50 );
        search.addActionListener( new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
                search();}});


        //************VIEW ALL************\\
        View = new Button( "VIEW ALL" );
        View.setBounds( 210, 300, 150, 50 );
        View.addActionListener( new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {

                viewAll();

        } });


//************DELETE************\\
        delete = new Button( "DELETE" );
        delete.setBounds( 210, 400, 150, 50 );
        delete.addActionListener( new ActionListener( ) {
            public void actionPerformed(ActionEvent e) {
            delete();}});



        f = new JFrame( "ADDRESS BOOK" );
        f.add( addnew );
        f.add( search );
        f.add( View );
        f.add( delete );
        f.setBackground( Color.lightGray );
        f.setSize( 600, 600 );
        f.setLayout( null );
        f.setVisible( true );
        JLabel title = new JLabel( "JYOTI'S ADDRESS BOOK", JLabel.CENTER );
        title.setSize( 30, 30 );
        title.setForeground( Color.BLUE );
        Font myFont = new Font( "Serif", Font.BOLD, 20 );
        title.setFont( myFont );
        title.setBounds( 180, 30, 250, 50 );
        f.add( title );
        f.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }

    public void add(){
        JFrame frame=new JFrame("ADD" );
        frame.setBackground( Color.lightGray );
        frame.setSize( 600,600 );
        frame.setLayout( null );
        frame.setVisible( true );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        JLabel title = new JLabel( "JYOTI'S ADDRESS BOOK", JLabel.CENTER );
        title.setSize( 30, 30 );
        title.setForeground( Color.BLUE );
        Font myFont = new Font( "Serif", Font.BOLD, 20 );
        title.setFont( myFont );
        title.setBounds( 180, 30, 250, 50 );
        frame.add( title );
                //****LABEL****\\
                UID = new JLabel( "USER ID" );
                UID.setBounds( 50, 100, 100, 30 );
                fn = new JLabel( "FIRST NAME" );
                fn.setBounds( 50, 150, 100, 30 );
                ln = new JLabel( "LAST NAME" );
                ln.setBounds( 50, 200, 100, 30 );
                pn = new JLabel( "PHONE NUMBER" );
                pn.setBounds( 50, 250, 100, 30 );
                ad = new JLabel( "ADDRESS " );
                ad.setBounds( 50, 300, 100, 30 );
                mail = new JLabel( "EMAIL ID" );
                mail.setBounds( 50, 350, 100, 30 );

                //****TEXTFIELD****\\
                TUID = new JTextField( );
                TUID.setBounds( 160, 100, 250, 30 );
                tfn = new JTextField( );
                tfn.setBounds( 160, 150, 250, 30 );
                tln = new JTextField( );
                tln.setBounds( 160, 200, 250, 30 );
                tpn = new JTextField( );
                tpn.setBounds( 160, 250, 250, 30 );
                tad = new JTextField( );
                tad.setBounds( 160, 300, 250, 30 );
                tmail = new JTextField( );
                tmail.setBounds( 160, 350, 250, 30 );

                //****REMOVE ON CREATE BUTTONS****\\


                //****ADD OF LABEL AND FIELDS****\\
                frame.add( UID );
                frame.add( fn );
                frame.add( ln );
                frame.add( pn );
                frame.add( ad );
                frame.add( mail );
                frame.add( TUID );
                frame.add( tfn );
                frame.add( tln );
                frame.add( tpn );
                frame.add( tad );
                frame.add( tmail );

                //****ADD BUTTON****\\
                Button B = new Button( "ADD" );
                B.setBounds( 220, 400, 150, 50 );
                frame.add( B );

                //****QUERY****\\
                B.addActionListener( new ActionListener( ) {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {


                            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );

                            Statement st = con.createStatement( );
                            String rs = "INSERT INTO mysql57.address  (ID,First_Name,Last_Name,Address,Contact_NO,Email_ID) values(?,?,?,?,?,?)";
                            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( rs );
                            preparedStatement.setString( 1, TUID.getText( ) );
                            preparedStatement.setString( 2, tfn.getText( ) );
                            preparedStatement.setString( 3, tln.getText( ) );
                            preparedStatement.setString( 4, tad.getText( ) );
                            preparedStatement.setString( 5, tpn.getText( ) );
                            preparedStatement.setString( 6, tmail.getText( ) );
                            preparedStatement.executeUpdate( );
                            JOptionPane.showMessageDialog( frame, "ADDED IN DATABASE" );

                        }
                        catch (Exception ex)
                        {
                            JOptionPane.showMessageDialog( frame, ex );

                        }
                    }
                } );

            }


    public void search(){
        JFrame frame=new JFrame("ADD" );
        frame.setBackground( Color.lightGray );
        frame.setSize( 600,600 );
        frame.setLayout( null );
        frame.setVisible( true );

        JLabel title = new JLabel( "JYOTI'S ADDRESS BOOK", JLabel.CENTER );
        title.setSize( 30, 30 );
        title.setForeground( Color.BLUE );
        Font myFont = new Font( "Serif", Font.BOLD, 20 );
        title.setFont( myFont );
        title.setBounds( 180, 30, 250, 50 );
        frame.add( title );
            //****LABEL****\\
            UID = new JLabel( "USER ID" );
            UID.setBounds( 50, 200, 100, 30 );

            //****TEXTFIELD****\\
            TUID = new JTextField( );
            TUID.setBounds( 160, 200, 250, 30 );


            //****ADD TEXTIELD,LABELS AND BUTTON****\\
            frame.add( TUID );
            frame.add( UID );
            Button B = new Button( "SEARCH" );
            B.setBounds( 220, 300, 150, 50 );
            frame.add( B );
            //****QUERY****\\
            B.addActionListener( new ActionListener( ) {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        if(TUID.getText().isEmpty()){
                            JOptionPane.showMessageDialog( f,"ENTER CUSTOMER ID" );
                        }
                        else {
                            findId( TUID.getText( ) );
                        }


                    } catch (Exception E) {
                        JOptionPane.showMessageDialog( frame, E );
                    }
                }
            } );
        frame.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

    }



    public void findId(String S){
        JFrame f1 = new JFrame( );
        f1.setVisible( true );
        try
        {
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
            String s = TUID.getText( );
            String sql = "select * from mysql57.address where ID = " +s;
            Statement st = con.createStatement( );
            PreparedStatement preparedStatement = con.prepareStatement( sql );
            ResultSet rs = preparedStatement.executeQuery(sql );
            boolean empty = true;
            while (rs.next( )) {
                empty = false;
            }
            if (empty) {
                JOptionPane.showMessageDialog( f1, "ID NOT FOUND IN DATABASE" );
                f1.setVisible( false );
            }
            else {
                idFound( S );
            }}
        catch (SQLException e)
        {
            System.out.println( e );
        }
        f1.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }



            //



    public void idFound(String S){
        JFrame  f2 = new JFrame("CUSTOMER HISTORY" );
        f2.setVisible( true );
        Vector columnNames = new Vector();
        Vector data = new Vector();
        try
        {
            String s= S;
            Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
            String sql = "select * from mysql57.address where ID = " +s;
            Statement st = con.createStatement( );
            PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( sql );
            ResultSet rs = st.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();
            for (int i = 1; i <= columns; i++)
            {
                columnNames.addElement( md.getColumnName(i) );
            }
            while (rs.next())
            {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++)
                {
                    row.addElement(rs.getObject(i));
                }
                data.addElement(row);
            }
            rs.close();
            st.close();
        }
        catch (SQLException e)
        {
            System.out.println( e );
        }
        JTable table = new JTable( data, columnNames );
        JScrollPane scrollPane = new JScrollPane( table );
        f2.add( scrollPane );
        f2.pack( );
        f2.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
    }


        public void viewAll(){
            JFrame f = new JFrame( );
            f.setVisible( true );
            Vector columnNames = new Vector();
            Vector data = new Vector();

            //*****QUERY*****\\

            try {
                Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true", "root", "root" );
                String sql = "select ID,First_Name,Last_Name,Contact_NO,ADDRESS,Email_ID from mysql57.address";
                Statement st = con.createStatement( );
                PreparedStatement preparedStatement = (PreparedStatement) con.prepareStatement( sql );
                ResultSet rs = st.executeQuery( sql );
                ResultSetMetaData md = rs.getMetaData();

                int columns = md.getColumnCount();

                for (int i = 1; i <= columns; i++)
                {
                    columnNames.addElement( md.getColumnName(i) );
                }
                while (rs.next())
                {
                    Vector row = new Vector(columns);
                    for (int i = 1; i <= columns; i++)
                    {
                        row.addElement(rs.getObject(i));
                    }
                    data.addElement(row);
                }
                rs.close();
                st.close();
            }
            catch (SQLException ex)
            {
                System.out.println( ex );
            }
            JTable table = new JTable(data, columnNames);
            JScrollPane scrollPane = new JScrollPane( table );
            f.add( scrollPane );
            f.pack();


        }


        public void delete(){
            JFrame f1 = new JFrame( );
            f1.setVisible( true );
        //****LABEL****\\
        UID=new JLabel("USER ID");
        UID.setBounds(50,150,100,30);

        //****TEXTFIELD****\\
        TUID=new JTextField();
        TUID.setBounds(160,150,250,30);



        //****ADD LABEL ,TEXTFIELD AND BUTTON****\\
        f1.add(TUID);
        f1.add(UID);
        Button B=new Button("DELETE");
        B.setBounds(200,350,150,50);
        f1.add(B);

        //****QUERY****\\

        B.addActionListener(new ActionListener(){
@Override
public void actionPerformed(ActionEvent e){
        try{
        String s=TUID.getText();
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?verifyServerCertificate=false&useSSL=true","root","root");
        Statement st=con.createStatement();
        String r="delete from mysql57.address where ID = "+s;
        PreparedStatement preparedStatement=con.prepareStatement(r);

        int rows=preparedStatement.executeUpdate();
        if(rows==0)
        {JOptionPane.showMessageDialog(f,"ID NOT FOUND IN DATABASE");
        f1.setVisible( false );


        }

        else{
        JOptionPane.showMessageDialog(f,"DELETED FROM DATABASE");
            f1.setVisible( false );

        }


        }
        catch(Exception ex){
        JOptionPane.showMessageDialog(f,ex);
        }
        }});
            f1.setBackground( Color.lightGray );
            f1.setSize( 500, 500 );
            f1.setLayout( null );
            f1.setVisible( true );
            f1.setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );

        }

        }