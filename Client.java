package chattingapplication;

import static chattingapplication.Server.dou;
import static chattingapplication.Server.f;
import static chattingapplication.Server.formatLabel;
import static chattingapplication.Server.vertical;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.net.*;

public class Client implements ActionListener {
    JTextField text;
    static  JPanel a1;
    static Box vertical;
    static JFrame f = new JFrame();
    static DataOutputStream dou;
    
    Client() {
        f.setLayout(null);
        
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        f.add(p1);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        JLabel back = new JLabel(new ImageIcon(i2));
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

       
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        JLabel profile = new JLabel(new ImageIcon(i5));
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        JLabel video = new JLabel(new ImageIcon(i8));
        video.setBounds(300, 20, 30, 30);
        p1.add(video);

        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        JLabel phone = new JLabel(new ImageIcon(i11));
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);

        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        JLabel morevert = new JLabel(new ImageIcon(i14));
        morevert.setBounds(420, 20, 10, 25);
        p1.add(morevert);

        
        JLabel name = new JLabel("Mangesh M");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.white);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 35, 100, 18);
        status.setForeground(Color.white);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);

      
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        a1.setLayout(new BorderLayout());
        f.add(a1);

        
        vertical = Box.createVerticalBox();
        a1.add(vertical, BorderLayout.PAGE_START);

        
        text = new JTextField();
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        f.add(text);

       
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        send.setForeground(Color.WHITE);
        f.add(send);

        
        f.setSize(455, 700);
        f.setLocation(800, 50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
             String out = text.getText().trim();

        if (out.isEmpty()) {
            showToast("Cannot send empty message!");
            return;
        }
            JPanel p2 = formatLabel(out);
            
            
            JPanel right = new JPanel(new BorderLayout());
            right.add(p2, BorderLayout.LINE_END);
            
            vertical.add(right);
            vertical.add(Box.createVerticalStrut(15)); // Adds spacing
            
            dou.writeUTF(out);
            
            a1.revalidate();
            a1.repaint();
             
            text.setText("");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static JPanel formatLabel(String out){
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel(("<html><p style = \" width: 140px;  margin: 5px; border-radius: 15px;\">"+out+"</p></html>"));
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 162));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50 ));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        return panel;
        
    }
    
    public static void showToast(String message) {
    JDialog dialog = new JDialog();
    dialog.setUndecorated(true);
    dialog.setLayout(new BorderLayout());

    JLabel label = new JLabel(message, SwingConstants.CENTER);
    label.setFont(new Font("Arial", Font.BOLD, 14));
    label.setOpaque(true);
    label.setBackground(new Color(255, 221, 221));
    label.setForeground(Color.BLACK);
    label.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

    dialog.add(label, BorderLayout.CENTER);
    dialog.pack();

    
    int x = f.getX() + f.getWidth() - dialog.getWidth() - 20;
    int y = f.getY() + f.getHeight() - dialog.getHeight() - 60;
    dialog.setLocation(x, y);

    dialog.setVisible(true);

    
    new Timer(2000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dialog.dispose();
        }
    }).start();
}


    public static void main(String args[]) {
        new Client();
        
        try{
            
                Socket s = new Socket("127.0.0.1", 6001);
                DataInputStream din = new DataInputStream(s.getInputStream());
                dou = new DataOutputStream(s.getOutputStream());
                
                 while(true){
               String msg = din.readUTF();
               JPanel panel =formatLabel(msg);
               
               JPanel left = new JPanel(new BorderLayout());
               left.add(panel, BorderLayout.LINE_START);
               vertical.add(left);
               
               vertical.add(Box.createVerticalStrut(15));
               a1.add(vertical, BorderLayout.PAGE_START);
               //showToast("New message received!");
               f.validate();
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
