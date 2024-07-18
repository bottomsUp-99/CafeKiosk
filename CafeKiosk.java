import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CafeKiosk {
    static class ImagePanel extends JPanel {
        private final Image img;
        private final Image manual_img = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/CafeManual.png").getImage();

        public ImagePanel(Image img) {
            this.img = img;
        }

        public void paintComponent(Graphics g) {
            g.drawImage(img, 0, 0, 1900, 1200, null);
            g.drawImage(manual_img, 1050, 300, 800, 600, null);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("WELCOME TO BUFS CAFE");
        ImagePanel pn = new ImagePanel(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/cafeview.jpg").getImage());
        frame.pack();
        frame.add(pn);
        JPanel Hotpn = new JPanel();
        JPanel Icepn = new JPanel();
        JPanel Adepn = new JPanel();
        JPanel Dessertpn = new JPanel();
        JPanel Orderpn = new JPanel();
        JTextArea ordertxt = new JTextArea();
        pn.add(ordertxt);
        ordertxt.append("[주문하신 음식를 확인하실 수 있습니다]\n");
        ordertxt.setBounds(250, 900, 1000, 150);
        ordertxt.setEditable(false);
        ordertxt.setFont(new Font("SansSerif", Font.BOLD, 20));
        JTextArea listtxt = new JTextArea();
        listtxt.setBounds(0, 0, 1600, 600);
        listtxt.setFont(new Font("SansSerif", Font.BOLD, 12));

        JButton[] bt = new JButton[7];
        JButton order_bt = new JButton("주문 담기");

        String[] heading = new String[]{"상품명", "가격"};
        Object[][] data = new Object[][]{
                {"상품명", "가격"},
                {"(Hot)아메리카노", "4000원"},
                {"(Hot)카푸치노", "4900원"},
                {"(Hot)에스프레소", "4500원"},
                {"(Hot)핫초코", "4200원"},
                {"(Hot)얼그레이티", "4000원"},
                {"(Hot)루이보스티", "4000원"},

                {"(Ice)아메리카노", "4500원"},
                {"(Ice)카페라떼", "5400원"},
                {"(Ice)돌체라떼", "5100원"},
                {"(Ice)카라멜마끼아또", "4900원"},
                {"(Ice)콜드브루", "5100원"},
                {"(Ice)아이스티", "4000원"},

                {"레몬에이드", "4800원"},
                {"자몽에이드", "5100원"},
                {"블루레몬에이드", "5300원"},
                {"청포도에이드", "4900원"},
                {"메가에이드", "5000원"},
                {"핑크에이드", "4700원"},

                {"초코케이크(1조각)", "5300원"},
                {"딸기케이크(1조각)", "6200원"},
                {"티라미수(1조각)", "6500원"},
                {"샌드위치(1조각)", "5500원"},
                {"베이글(1조각)", "5500원"},
                {"샐러드", "6400원"}
        };

        JTable table = new JTable(data, heading);
        pn.add(new JScrollPane(table));
        pn.add(table);
        table.setBounds(250, 300, 800, 600);
        table.setFont(new Font("맑은 고딕", Font.BOLD, 19));
        table.setRowHeight(24);

        int[] width = {300, 300, 300, 300, 200, 200, 200};
        int[] height = {150, 150, 150, 150, 100, 100, 100};
        int[] x = {80, 480, 880, 1280, 30, 30, 30};
        int[] y = {100, 100, 100, 100, 300, 500, 700};

        pn.setLayout(null);
        pn.setBounds(0, 0, 1900, 1200);
        CafeSystem.setupMenu();

        bt[0] = new JButton("HOT");
        bt[1] = new JButton("ICE");
        bt[2] = new JButton("ADE");
        bt[3] = new JButton("Dessert");
        bt[4] = new JButton("Main");
        bt[5] = new JButton("Order");
        bt[6] = new JButton("Exit");

        for (int i = 0; i < bt.length; i++) {
            pn.add(bt[i]);
            bt[i].setBounds(x[i], y[i], width[i], height[i]);
            bt[i].setFont(new Font("Blackadder ITC", Font.BOLD, 60));
            bt[i].setContentAreaFilled(false);
            bt[i].setBorderPainted(false);
            bt[i].setFocusPainted(false);
            bt[i].setForeground(Color.WHITE);
        }

        bt[0].addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[0]) {
                    doHot();
                    Hotpn.setLayout(null);
                    Hotpn.setBounds(250, 300, 1600, 600);
                    Hotpn.setBackground(Color.gray);
                    Hotpn.setVisible(true);
                    Icepn.setVisible(false);
                    Adepn.setVisible(false);
                    Dessertpn.setVisible(false);
                    Orderpn.setVisible(false);
                    ordertxt.setVisible(true);
                    table.setVisible(false);
                    order_bt.setVisible(true);
                }
            }
            private void doHot() {
                JButton HotButton_Americano = new JButton("");
                frame.add(Hotpn);
                HotButton_Americano.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/HotAmericano.jpg"));
                Hotpn.add(HotButton_Americano);
                HotButton_Americano.setBounds(20, 20, 260,195);
                JTextField hot_Americano = new JTextField("(HOT)아메리카노  4000원");
                Hotpn.add(hot_Americano);
                hot_Americano.setBounds(20,215,260,30);
                hot_Americano.setEditable(false);
                HotButton_Americano.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_Americano) {
                            int result=	JOptionPane.showConfirmDialog(HotButton_Americano, "아메리카노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(0).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(0));
                                CafeSystem.new_Price(4000);
                            }
                        }
                    }});

                JButton HotButton_Cappuccino = new JButton("");
                HotButton_Cappuccino.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/HotCappuccino.jpg"));
                Hotpn.add(HotButton_Cappuccino);
                HotButton_Cappuccino.setBounds(280, 20, 260, 195);
                JTextField Cappuccino = new JTextField("(Hot)카푸치노  4900원");
                Hotpn.add(Cappuccino);
                Cappuccino.setBounds(280,215,260,30);
                Cappuccino.setEditable(false);
                HotButton_Cappuccino.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_Cappuccino) {
                            int result = JOptionPane.showConfirmDialog(HotButton_Cappuccino, "카푸치노를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(1).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(1));
                                CafeSystem.new_Price(4900);
                            }
                        }
                    }});

                JButton HotButton_Espresso = new JButton("");
                HotButton_Espresso.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/Espresso.jpg"));
                Hotpn.add(HotButton_Espresso);
                HotButton_Espresso.setBounds(540, 20, 260, 195);
                JTextField Espresso = new JTextField("(Hot)에스프레소  4500원");
                Hotpn.add(Espresso);
                Espresso.setBounds(540,215,260,30);
                Espresso.setEditable(false);
                HotButton_Espresso.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_Espresso) {
                            int result = JOptionPane.showConfirmDialog(HotButton_Espresso, "에스프레소를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(2).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(2));
                                CafeSystem.new_Price(4500);
                            }
                        }
                    }});

                JButton HotButton_HotChoco = new JButton("");
                HotButton_HotChoco.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/HotChoco.jpg"));
                Hotpn.add(HotButton_HotChoco);
                HotButton_HotChoco.setBounds(800, 20, 260, 195);
                JTextField HotChoco = new JTextField("(Hot)핫초코  4200원");
                Hotpn.add(HotChoco);
                HotChoco.setBounds(800,215,260,30);
                HotChoco.setEditable(false);
                HotButton_HotChoco.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_HotChoco) {
                            int result = JOptionPane.showConfirmDialog(HotButton_HotChoco, "핫초코를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(3).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(3));
                                CafeSystem.new_Price(4200);
                            }
                        }
                    }});

                JButton HotButton_EarlgreyTea = new JButton("");
                HotButton_EarlgreyTea.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/EarlgreyTea.jpg"));
                Hotpn.add(HotButton_EarlgreyTea);
                HotButton_EarlgreyTea.setBounds(1060, 20, 260, 195);
                JTextField EarlgreyTea = new JTextField("(Hot)얼그레이티  4400원");
                Hotpn.add(EarlgreyTea);
                EarlgreyTea.setBounds(1060,215,260,30);
                EarlgreyTea.setEditable(false);
                HotButton_EarlgreyTea.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_EarlgreyTea) {
                            int result = JOptionPane.showConfirmDialog(HotButton_EarlgreyTea, "얼그레이티를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(4).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(4));
                                CafeSystem.new_Price(4400);
                            }
                        }
                    }});

                JButton HotButton_RooibosTea = new JButton("");
                HotButton_RooibosTea.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Hot/RooibosTea.jpg"));
                Hotpn.add(HotButton_RooibosTea);
                HotButton_RooibosTea.setBounds(1320, 20, 260, 195);
                JTextField RooibosTea = new JTextField("(Hot)루이보스티  4400원");
                Hotpn.add(RooibosTea);
                RooibosTea.setBounds(1320,215,260,30);
                RooibosTea.setEditable(false);
                HotButton_RooibosTea.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==HotButton_RooibosTea) {
                            int result = JOptionPane.showConfirmDialog(HotButton_RooibosTea, "루이보스티를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.hot_drink.get(5).toString()));
                                CafeSystem.order.add(CafeSystem.hot_drink.get(5));
                                CafeSystem.new_Price(4400);
                            }
                        }
                    }});
                }
            }
        );

        bt[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn = (JButton) e.getSource();
                if (srcBtn == bt[1]) {
                    doICE();
                    Icepn.setLayout(null);
                    Icepn.setBounds(250, 300, 1600, 600);
                    Icepn.setBackground(Color.gray);
                    Hotpn.setVisible(false);
                    Icepn.setVisible(true);
                    Adepn.setVisible(false);
                    Dessertpn.setVisible(false);
                    Orderpn.setVisible(false);
                    ordertxt.setVisible(true);
                    table.setVisible(false);
                    order_bt.setVisible(true);
                }
            }
            private void doICE() {
                frame.add(Icepn);
                JButton IceButton_Americano = new JButton("");
                IceButton_Americano.setIcon(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/IceAmericano.jpg"));
                Icepn.add(IceButton_Americano);
                IceButton_Americano.setBounds(20, 20, 260, 195);
                JTextField Ice_Amricano = new JTextField("(ICE)아메리카노  4500원");
                Icepn.add(Ice_Amricano);
                Ice_Amricano.setBounds(20, 215, 260, 30);
                Ice_Amricano.setEditable(false);
                IceButton_Americano.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn = (JButton) e.getSource();
                        if (srcBtn == IceButton_Americano) {
                            int result = JOptionPane.showConfirmDialog(IceButton_Americano, "아이스아메리카노를 주문하시겟습니까?", "주문확인", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                            if (result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(0).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(0));
                                CafeSystem.new_Price(4500);
                            }
                        }
                    }
                });
                ImageIcon icon_CafeLatte = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/IceCafeLatte.jpg");
                JButton IceButton_CafeLatte = new JButton(CafeSystem.resizeIcon(icon_CafeLatte, 259, 194));
                Icepn.add(IceButton_CafeLatte);
                IceButton_CafeLatte.setBounds(280, 20, 260,195);
                JTextField Ice_CafeLatte = new JTextField("(ICE)카페라떼  5400원");
                Icepn.add(Ice_CafeLatte);
                Ice_CafeLatte.setBounds(280,215,260,30);
                Ice_CafeLatte.setEditable(false);
                IceButton_CafeLatte.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==IceButton_CafeLatte) {
                            int result = JOptionPane.showConfirmDialog(IceButton_CafeLatte, "아이스 카페라떼를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(1).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(1));
                                CafeSystem.new_Price(5400);
                            }
                        }
                    }
                });
                ImageIcon icon_DolceLatte = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/DolceLatte.jpg");
                JButton IceButton_DolceLatte = new JButton(CafeSystem.resizeIcon(icon_DolceLatte, 259, 194));
                Icepn.add(IceButton_DolceLatte);
                IceButton_DolceLatte.setBounds(540, 20, 260,195);
                JTextField Ice_DolceLatte = new JTextField("(ICE)돌체라떼  5100원");
                Icepn.add(Ice_DolceLatte);
                Ice_DolceLatte.setBounds(540,215,260,30);
                Ice_DolceLatte.setEditable(false);
                IceButton_DolceLatte.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==IceButton_DolceLatte) {
                            int result = JOptionPane.showConfirmDialog(IceButton_DolceLatte, "아이스 돌체라떼를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(2).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(2));
                                CafeSystem.new_Price(5100);
                            }
                        }
                    }
                });
                ImageIcon icon_CaramelMacchiato = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/CaramelMacchiato.jpg");
                JButton IceButton_CaramelMacchiato = new JButton(CafeSystem.resizeIcon(icon_CaramelMacchiato, 259, 194));
                Icepn.add(IceButton_CaramelMacchiato);
                IceButton_CaramelMacchiato.setBounds(800, 20, 260,195);
                JTextField Ice_CaramelMacchiato = new JTextField("(ICE)카라멜마끼아또  4900원");
                Icepn.add(Ice_CaramelMacchiato);
                Ice_CaramelMacchiato.setBounds(800,215,260,30);
                Ice_CaramelMacchiato.setEditable(false);
                IceButton_CaramelMacchiato.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==IceButton_CaramelMacchiato) {
                            int result = JOptionPane.showConfirmDialog(IceButton_CaramelMacchiato, "아이스 카라멜마끼아또를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(3).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(3));
                                CafeSystem.new_Price(4900);
                            }
                        }
                    }
                });
                ImageIcon icon_ColdBrew = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/ColdBrew.jpg");
                JButton IceButton_ColdBrew = new JButton(CafeSystem.resizeIcon(icon_ColdBrew, 259, 194));
                Icepn.add(IceButton_ColdBrew);
                IceButton_ColdBrew.setBounds(1060, 20, 260,195);
                JTextField Ice_ColdBrew = new JTextField("(ICE)콜드브루  5100원");
                Icepn.add(Ice_ColdBrew);
                Ice_ColdBrew.setBounds(1060,215,260,30);
                Ice_ColdBrew.setEditable(false);
                IceButton_ColdBrew.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==IceButton_ColdBrew) {
                            int result = JOptionPane.showConfirmDialog(IceButton_ColdBrew, "아이스 콜드브루를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(4).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(4));
                                CafeSystem.new_Price(5100);
                            }
                        }
                    }
                });
                ImageIcon icon_IceTea = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ice/IceTea.jpg");
                JButton IceButton_IceTea = new JButton(CafeSystem.resizeIcon(icon_IceTea, 259, 194));
                Icepn.add(IceButton_IceTea);
                IceButton_IceTea.setBounds(1320, 20, 260,195);
                JTextField Ice_IceTea = new JTextField("(ICE)아이스티  4000원");
                Icepn.add(Ice_IceTea);
                Ice_IceTea.setBounds(1320,215,260,30);
                Ice_IceTea.setEditable(false);
                IceButton_IceTea.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==IceButton_IceTea) {
                            int result = JOptionPane.showConfirmDialog(IceButton_IceTea, "아이스티를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ice_drink.get(5).toString()));
                                CafeSystem.order.add(CafeSystem.ice_drink.get(5));
                                CafeSystem.new_Price(4000);
                            }
                        }
                    }
                });
            }
        });

        bt[2].addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn = (JButton)e.getSource();
                if(srcBtn==bt[2]) {
                    doAde();
                    Adepn.setLayout(null);
                    Adepn.setBounds(250, 300, 1600, 600);
                    Adepn.setBackground(Color.gray);
                    Hotpn.setVisible(false);
                    Icepn.setVisible(false);
                    Adepn.setVisible(true);
                    Dessertpn.setVisible(false);
                    Orderpn.setVisible(false);
                    ordertxt.setVisible(true);
                    table.setVisible(false);
                    order_bt.setVisible(true);
                }
            }

            private void doAde() {
                frame.add(Adepn);
                JButton AdeButton_Lemonade = new JButton(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/Lemonade.jpg"));
                Adepn.add(AdeButton_Lemonade);
                AdeButton_Lemonade.setBounds(20, 20, 260,195);
                JTextField Lemonade = new JTextField("레몬에이드  4800원");
                Adepn.add(Lemonade);
                Lemonade.setBounds(20,215,260,30);
                Lemonade.setEditable(false);
                AdeButton_Lemonade.addActionListener(new ActionListener () {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_Lemonade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_Lemonade, "레몬에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(0).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(0));
                                CafeSystem.new_Price(4800);
                            }
                        }
                    }
                });
                ImageIcon icon_Grapefruitade = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/Grapefruitade.jpg");
                JButton AdeButton_Grapefruitade = new JButton(CafeSystem.resizeIcon(icon_Grapefruitade, 260, 195));
                Adepn.add(AdeButton_Grapefruitade);
                AdeButton_Grapefruitade.setBounds(280, 20, 260,195);
                JTextField Grapefruitade = new JTextField("자몽에이드  5100원");
                Adepn.add(Grapefruitade);
                Grapefruitade.setBounds(280,215,260,30);
                Grapefruitade.setEditable(false);
                AdeButton_Grapefruitade.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_Grapefruitade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_Grapefruitade, "자몽에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(1).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(1));
                                CafeSystem.new_Price(5100);
                            }
                        }
                    }
                });
                ImageIcon icon_BlueLemonade = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/BlueLemonade.jpg");
                JButton AdeButton_BlueLemonade = new JButton(CafeSystem.resizeIcon(icon_BlueLemonade, 260, 195));
                Adepn.add(AdeButton_BlueLemonade);
                AdeButton_BlueLemonade.setBounds(540, 20, 260,195);
                JTextField BlueLemonade = new JTextField("블루레몬에이드  5300원");
                Adepn.add(BlueLemonade);
                BlueLemonade.setBounds(540,215,260,30);
                BlueLemonade.setEditable(false);
                AdeButton_BlueLemonade.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_BlueLemonade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_BlueLemonade, "블루레몬에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(2).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(2));
                                CafeSystem.new_Price(5300);
                            }
                        }
                    }
                });
                ImageIcon icon_Greenade = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/Greenade.jpg");
                JButton AdeButton_Greenade = new JButton(CafeSystem.resizeIcon(icon_Greenade, 260, 195));
                Adepn.add(AdeButton_Greenade);
                AdeButton_Greenade.setBounds(800, 20, 260,195);
                JTextField Greenade = new JTextField("청포도에이드  4900원");
                Adepn.add(Greenade);
                Greenade.setBounds(800,215,260,30);
                Greenade.setEditable(false);
                AdeButton_Greenade.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_Greenade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_Greenade, "청포도에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(3).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(3));
                                CafeSystem.new_Price(4900);
                            }
                        }
                    }
                });
                ImageIcon icon_Megaade = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/Megaade.jpg");
                JButton AdeButton_Megaade = new JButton(CafeSystem.resizeIcon(icon_Megaade, 260, 195));
                Adepn.add(AdeButton_Megaade);
                AdeButton_Megaade.setBounds(1060, 20, 260,195);
                JTextField Megaade = new JTextField("메가에이드  5000원");
                Adepn.add(Megaade);
                Megaade.setBounds(1060,215,260,30);
                Megaade.setEditable(false);
                AdeButton_Megaade.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_Megaade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_Megaade, "메가에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(4).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(4));
                                CafeSystem.new_Price(5000);
                            }
                        }
                    }
                });
                ImageIcon icon_Pinkade = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Ade/Pinkade.jpg");
                JButton AdeButton_Pinkade = new JButton(CafeSystem.resizeIcon(icon_Pinkade, 260, 195));
                Adepn.add(AdeButton_Pinkade);
                AdeButton_Pinkade.setBounds(1320, 20, 260,195);
                JTextField Pinkade = new JTextField("핑크에이드  4700원");
                Adepn.add(Pinkade);
                Pinkade.setBounds(1320,215,260,30);
                Pinkade.setEditable(false);
                AdeButton_Pinkade.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==AdeButton_Pinkade) {
                            int result=	JOptionPane.showConfirmDialog(AdeButton_Pinkade, "핑크에이드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.ade_drink.get(5).toString()));
                                CafeSystem.order.add(CafeSystem.ade_drink.get(5));
                                CafeSystem.new_Price(4700);
                            }
                        }
                    }
                });
            }});

        bt[3].addActionListener(new ActionListener () {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn = (JButton)e.getSource();
                if(srcBtn==bt[3]) {
                    doDessert();
                    Dessertpn.setLayout(null);
                    Dessertpn.setBounds(250, 300, 1600, 600);
                    Dessertpn.setBackground(Color.gray);
                    Hotpn.setVisible(false);
                    Icepn.setVisible(false);
                    Adepn.setVisible(false);
                    Dessertpn.setVisible(true);
                    Orderpn.setVisible(false);
                    ordertxt.setVisible(true);
                    table.setVisible(false);
                    order_bt.setVisible(true);
                }
            }
            private void doDessert() {
                frame.add(Dessertpn);
                JButton DstButton_ChocolateCake = new JButton(new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/ChocolateCake.jpg"));
                Dessertpn.add(DstButton_ChocolateCake);
                DstButton_ChocolateCake.setBounds(20, 20, 260,195);
                JTextField ChocolateCake = new JTextField("초코케이크 (1조각) 5300원");
                Dessertpn.add(ChocolateCake);
                ChocolateCake.setBounds(20,215,260,30);
                ChocolateCake.setEditable(false);
                DstButton_ChocolateCake.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_ChocolateCake) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_ChocolateCake, "초코케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(0).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(0));
                                CafeSystem.new_Price(5300);
                            }

                        }
                    }
                });
                ImageIcon icon_StrawberryCake = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/StrawberryCake.jpg");
                JButton DstButton_StrawberryCake = new JButton(CafeSystem.resizeIcon(icon_StrawberryCake, 260, 195));
                Dessertpn.add(DstButton_StrawberryCake);
                DstButton_StrawberryCake.setBounds(280, 20, 260,195);
                JTextField StrawberryCake = new JTextField("딸기케이크 (1조각) 6200원");
                Dessertpn.add(StrawberryCake);
                StrawberryCake.setBounds(280,215,260,30);
                StrawberryCake.setEditable(false);
                DstButton_StrawberryCake.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_StrawberryCake) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_StrawberryCake, "딸기케이크를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(1).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(1));
                                CafeSystem.new_Price(6200);
                            }

                        }
                    }
                });
                ImageIcon icon_Tiramisu = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/Tiramisu.jpg");
                JButton DstButton_Tiramisu = new JButton(CafeSystem.resizeIcon(icon_Tiramisu, 260, 195));
                Dessertpn.add(DstButton_Tiramisu);
                DstButton_Tiramisu.setBounds(540, 20, 260,195);
                JTextField Tiramisu = new JTextField("티라미수 (1조각) 6500원");
                Dessertpn.add(Tiramisu);
                Tiramisu.setBounds(540,215,260,30);
                Tiramisu.setEditable(false);
                DstButton_Tiramisu.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_Tiramisu) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_Tiramisu, "티라미수를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(2).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(2));
                                CafeSystem.new_Price(6500);
                            }

                        }
                    }
                });
                ImageIcon icon_Sandwich = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/Sandwich.jpg");
                JButton DstButton_Sandwich = new JButton(CafeSystem.resizeIcon(icon_Sandwich, 260, 195));
                Dessertpn.add(DstButton_Sandwich);
                DstButton_Sandwich.setBounds(800, 20, 260,195);
                JTextField Sandwich = new JTextField("샌드위치 (1조각) 5500원");
                Dessertpn.add(Sandwich);
                Sandwich.setBounds(800,215,260,30);
                Sandwich.setEditable(false);
                DstButton_Sandwich.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_Sandwich) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_Sandwich, "샌드위치를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(3).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(3));
                                CafeSystem.new_Price(5500);
                            }

                        }
                    }
                });
                ImageIcon icon_Bagel = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/Bagel.jpg");
                JButton DstButton_Bagel = new JButton(CafeSystem.resizeIcon(icon_Bagel, 260, 195));
                Dessertpn.add(DstButton_Bagel);
                DstButton_Bagel.setBounds(1060, 20, 260,195);
                JTextField Bagel = new JTextField("베이글 (1조각) 5500원");
                Dessertpn.add(Bagel);
                Bagel.setBounds(1060,215,260,30);
                Bagel.setEditable(false);
                DstButton_Bagel.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_Bagel) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_Bagel, "베이글을 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(4).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(4));
                                CafeSystem.new_Price(5500);
                            }

                        }
                    }
                });
                ImageIcon icon_Salad = new ImageIcon("/Users/zoohwan_99/Documents/인텔리제이 자료/CafeKiosk/img/Dessert/Salad.jpg");
                JButton DstButton_Salad = new JButton(CafeSystem.resizeIcon(icon_Salad, 260, 195));
                Dessertpn.add(DstButton_Salad);
                DstButton_Salad.setBounds(1320, 20, 260,195);
                JTextField Salad = new JTextField("샐러드 (1조각) 6400원");
                Dessertpn.add(Salad);
                Salad.setBounds(1320,215,260,30);
                Salad.setEditable(false);
                DstButton_Salad.addActionListener(new ActionListener () {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton srcBtn =(JButton)e.getSource();
                        if(srcBtn==DstButton_Salad) {
                            int result=	JOptionPane.showConfirmDialog(DstButton_Salad, "샐러드를 주문하시겟습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(result == JOptionPane.OK_OPTION) {
                                ordertxt.append((CafeSystem.dessert.get(5).toString()));
                                CafeSystem.order.add(CafeSystem.dessert.get(5));
                                CafeSystem.new_Price(6400);
                            }

                        }
                    }
                });
            }});

        bt[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[4]) {
                    Hotpn.setVisible(false);
                    Icepn.setVisible(false);
                    Adepn.setVisible(false);
                    Dessertpn.setVisible(false);
                    Orderpn.setVisible(false);
                    ordertxt.setVisible(false);
                    table.setVisible(true);
                    order_bt.setVisible(false);
                }
            }
        });

        bt[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[5]) {
                    frame.add(Orderpn);
                    Hotpn.setVisible(false);
                    Icepn.setVisible(false);
                    Adepn.setVisible(false);
                    Dessertpn.setVisible(false);
                    Orderpn.setVisible(true);
                    ordertxt.setVisible(false);
                    table.setVisible(false);
                    order_bt.setVisible(false);
                    Orderpn.add(listtxt);
                    Orderpn.setBounds(250, 300, 1600, 600);
                    Orderpn.setBackground(Color.white);
                }
            }
        });
        bt[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==bt[6]) {
                    System.exit(0);
                }
            }
        });

        order_bt.setFont(new Font("돋움", Font.PLAIN, 25));
        order_bt.setBounds(1300, 900, 300, 150);
        pn.add(order_bt);
        order_bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton srcBtn =(JButton)e.getSource();
                if(srcBtn==order_bt) {
                    int result = JOptionPane.showConfirmDialog(order_bt, "주문하시겠습니까?", "주문확인",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
                    if(result==JOptionPane.OK_OPTION) {
                        Custmoer_Order();
                        ordertxt.setText("");
                        int sum = 0;
                        listtxt.append(CafeSystem.total_Price(sum));
                        ordertxt.append("<주문하신 물품을 확인할수 있습니다.> \n\n");
                        CafeSystem.order.removeAllElements();
                        CafeSystem.price.removeAllElements();
                    }
                }
            }
            private void Custmoer_Order() {
                Menu m;
                listtxt.append("------------------------모든 주문 리스트-------------------------\n");
                for(int i=0; i<CafeSystem.getNumOrders(); i++) {
                    m=CafeSystem.getOrder(i);
                    listtxt.append(i+1+". ");
                    listtxt.append(m.toString());
                }
                listtxt.append("\n------------------------------------------------------------------------\n");
            }
        });
        ordertxt.setVisible(false);
        order_bt.setVisible(false);
        frame.setContentPane(pn);
        frame.setLocation(0,0);
        frame.setSize(1900, 1100);
        frame.setVisible(true);

        // JFrame 크기 변경 시 JPanel 크기를 조정하는 ComponentListener 추가
        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newSize = frame.getSize();
                pn.setSize(newSize);
                pn.revalidate(); // 패널을 다시 그리도록 요청

                listtxt.setSize(newSize);
                listtxt.revalidate();
            }
        });

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // JFrame의 크기를 화면 크기로 설정
        frame.setSize(screenSize.width, screenSize.height);
        // JFrame을 화면의 중앙에 배치
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}