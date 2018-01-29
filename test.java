package PersonnelManagementSystem;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ttc on 18-1-23.
 */
//主类
public class test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        method method = new method();
        while (true) {
            System.out.println("欢迎使用Mtlll的用户管理系统");
            System.out.println("===========================");
            System.out.println("用户登录------------------1");
            System.out.println("用户注册------------------2");
            System.out.println("退出程序------------------3");
            int num = scanner.nextInt();
            if (num == 1) {
//            per per=new per();
                System.out.println("用户登录界面");
                System.out.println("=======================");
                System.out.println("请输入姓名");
                String name = scanner.next();
                System.out.println("请输入密码");
                String psd = scanner.next();

                per p = method.selectPer(name, psd);
                if (p != null) {
                    System.out.println("登陆成功");
                    System.out.println("===================");
                    System.out.println("欢迎登录主窗体");
                    System.out.print(p.getPname() + "你好：\t");
                    System.out.println("你的权限是：" + p.getPidentity());
                    System.out.println("========================");
                    if (p.getPidentity().equals("管理员")) {
                        while (true) {
                            System.out.println("添加用户-------------1");
                            System.out.println("删除用户-------------2");
                            System.out.println("修改用户-------------3");
                            System.out.println("查询用户-------------4");
                            System.out.println("退出程序-------------5");
                            int num2 = scanner.nextInt();
                            switch (num2) {
                                case 1: {
                                    System.out.println("请输入添加的用户名");
                                    String addName = scanner.next();

                                    System.out.println("请输入密码");
                                    String addPsd = scanner.next();
                                    System.out.println("输入添加的生日");
                                    String d = scanner.next();
                                    System.out.println("请输入添加的身份");
                                    String identity = scanner.next();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    Date date = simpleDateFormat.parse(d);
                                    per per = new per();
                                    per.setPname(addName);
                                    per.setPidentity(identity);
                                    per.setPpassword(addPsd);
                                    per.setPbirthday(date);
                                    method.addNewPer(per);
                                    System.out.println("添加用户成功");
                                    break;
                                }
                                case 2: {
                                    System.out.println("请输入要删除用户的id号码");
                                    int num3 = scanner.nextInt();
                                    method.deletePer(num3);
                                    System.out.println("删除成功");
                                    break;
                                }
                                case 3: {
                                    System.out.println("请输入要修改的id");
                                    int alterId = scanner.nextInt();
                                    System.out.println("请输入要修改的姓名");
                                    String alterName = scanner.next();
                                    System.out.println("请输入要修改的密码");
                                    String alterPassword = scanner.next();
                                    System.out.println("请输入要修改的生日");
                                    String alterBirthday = scanner.next();
                                    System.out.println("请输要修改的身份");
                                    String stute = scanner.next();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    Date alterBirth = simpleDateFormat.parse(alterBirthday);
                                    per alterPer = new per();
                                    alterPer.setPidentity(stute);
                                    alterPer.setPpassword(alterPassword);
                                    alterPer.setPid(alterId);
                                    alterPer.setPname(alterName);
                                    alterPer.setPbirthday(alterBirth);
                                    method.Per(alterPer);
                                    System.out.println("修改成功");
                                    break;
                                }
                                case 4: {
                                    System.out.println("查询全部用户------------1");
                                    System.out.println("根据id查询用户------------2");
                                    System.out.println("根据姓名查询用户------------3");
                                    System.out.println("请输入要执行的操作");
                                    int num3 = scanner.nextInt();
                                    if (num3 == 1) {
                                        List<per> listt = method.selectPerAll();
                                        for (per a : listt) {
                                            System.out.println(a);
                                        }
                                        break;
                                    } else if (num3 == 2) {
                                        System.out.println("请输入要查询的pid");
                                        int id = scanner.nextInt();
                                        per selelct = method.selectPer(id);
                                        System.out.println(selelct);
                                        break;
                                    } else if (num3 == 3) {
                                        System.out.println("请输入要查询的用户名(支持模糊查询)");
                                        String selectName = scanner.next();
                                        per select = method.selectPer(selectName);
                                        System.out.println(select);
                                        break;
                                    } else {
                                        System.out.println("没有该选项");
                                        break;
                                    }

                                }
                                case 5: {
                                    return;
                                }
                                default: {
                                    break;
                                }
                            }
                        }
                    }
                    while (true) {
                        System.out.println("修改自己的信息----------1");
                        System.out.println("查询自己的信息----------2");
                        System.out.println("程序退出-----------3");
                        int index = scanner.nextInt();
                        switch (index) {
                            case 1: {
                                System.out.println("您现在的信息是：");
                                System.out.println(p.getPid() + "\t" + p.getPname() + "\t" + p.getPbirthday() + "\t" + p.getPidentity());
                                System.out.println("=======================");
                                System.out.println("请输入要修改的姓名");
                                String alterName = scanner.next();
                                System.out.println("请输入要修改的密码");
                                String alterPassword = scanner.next();
                                System.out.println("请输入要修改的生日");
                                String alterBirthday = scanner.next();
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                Date alterBirth = simpleDateFormat.parse(alterBirthday);
                                p.setPpassword(alterPassword);
                                p.setPname(alterName);
                                p.setPbirthday(alterBirth);
                                method.updatePer(p);

                                System.out.println("修改成功");
                                break;
                            }
                            case 2: {
                                per P = method.selectPer(p.getPid());
                                System.out.println(P);
                                break;
                            }
                            case 3: {
                                return;
                            }
                            default: {
                                break;
                            }
                        }

                    }
                } else {
                    System.out.println("登录失败");
                }

            }
            else if(num==2) {
                System.out.println("请输入姓名");
                String alterName = scanner.next();
                System.out.println("请输入密码");
                String alterPassword = scanner.next();
                System.out.println("请输入生日");
                String alterBirthday = scanner.next();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date alterBirth = simpleDateFormat.parse(alterBirthday);
                System.out.println("输入身份");
                String indetity = scanner.next();
                per p = new per();
                p.setPidentity(indetity);
                p.setPbirthday(alterBirth);
                p.setPname(alterName);
                p.setPpassword(alterPassword);
                method.addNewPer(p);
                System.out.println("添加用户成功");
            }
            else if(num==3)
            {
                break;
            }
            else{
                System.out.println("没有该选项，输入错误");
            }
        }
    }
}