package com.yckj.uol.servlet;


import com.google.gson.Gson;
import com.yckj.uol.pojo.PageBean;
import com.yckj.uol.pojo.QueryItem;
import com.yckj.uol.pojo.User;
import com.yckj.uol.service.IUserService;
import com.yckj.uol.service.Impl.UserServiceImpl;
import org.apache.log4j.Logger;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:描述 【用户模块】
 * Copyright:Copyright(c) 2020
 * Company 英才汇硕有限公司
 * @author cjs <br>
 * @version 1.0 <br>
 * @created Administrator 2020/9/1
 */
@WebServlet(value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserServiceImpl();
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置响应编码，防止页面中文乱码
        resp.setContentType("text/html;charset=utf-8");
        // 获取方法名称
        String method = req.getParameter("method");
        System.out.println("method=" + method);
        if ("addUser".equals(method)){
            this.addUser(req,resp);
        }else if ("updateUser".equals(method)){
            this.updateUser(req,resp);
        }else if ("deleteByUser_id".equals(method)){
            this.deleteByUser_id(req,resp);
        }else if ("selectByUser_id".equals(method)){
            this.selectByUser_id(req,resp);
        }else if ("pageSelect".equals(method)){
            this.pageSelect(req,resp);
        }else if("batchDelete".equals(method)){
            this.batchDelete(req,resp);
        }else if("selectDetailByUser_id".equals(method)){
            this.selectDetailByUser_id(req,resp);
        }else if ("selectAll".equals(method)) {
            this.selectAll(req, resp);
        }else if("selectByCondition".equals(method)){
            this.selectByCondition(req,resp);
        }else if("editState".equals(method)){
            this.editState(req,resp);
        }else{
            logger.debug("请求的地址不存在");
        }
    }

    /**
     * 批量删除
     * @param req
     * @param resp
     * @throws IOException
     */
    private void batchDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String ids = req.getParameter("ids");
        logger.debug("接收到的参数"+ids);
        if(ids != null){
            String[] idsArr = ids.split(",");
            logger.debug(Arrays.toString(idsArr));
            int[] idsArr1 = new int[idsArr.length];
            for (int i = 0; i < idsArr1.length;i++){
                if(idsArr[i] != null && idsArr[i] !="") {
                    int num = Integer.parseInt(idsArr[i]);
                    idsArr1[i] = num;
                }
            }
            logger.debug("转换后的ids数组："+Arrays.toString(idsArr));
            boolean flag = userService.deleteBatch(idsArr1);
            PrintWriter writer = resp.getWriter();
            if (flag) {
                writer.println(1);
            } else {
                writer.println(0);
            }
            writer.close();
        }

    }

    /**
     * 修改用户状态
     * @param req
     * @param resp
     * @throws IOException
     */
    private void editState(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user_id = req.getParameter("user_id");
        IUserService userService = new UserServiceImpl();
        int id = 0 ;
        if(user_id != null){
            id = Integer.parseInt(user_id);
            logger.debug(id);
        }else{
            logger.debug("user_id转换异常");
        }
        int state = 0;
        String state1 = req.getParameter("user_state");
        if(state1 != null){
            state = Integer.parseInt(state1);
        }else{
            logger.debug("state转换异常");
        }
        boolean flag = userService.updateStatusByUser_id(id, state);
        logger.debug("修改是否成功"+flag);
        PrintWriter writer = resp.getWriter();
        writer.print(flag);
        writer.close();
    }

    /**
     * 动态分页查询按：按姓名、院系、专业、班级、年级组合查询用户信息
     * @param req
     * @param resp
     * @throws IOException
     */
    private void selectByCondition(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String data = req.getParameter("data");
        System.out.println("接收的参数"+data);
        QueryItem item = null;
        Gson gson = new Gson();
        if(data == null) {
            item = null;
        }else{
            // 1.封装成QueryItem
            // 将JSON字符串转换成Java对象
            item = gson.fromJson(data, QueryItem.class);
            if((item.getUser_name()==null||"".equals(item.getUser_name()))&&(item.getUser_major()==null||"".equals(item.getUser_major()))&&(item.getUser_dep()==null||"".equals(item.getUser_dep()))&&(item.getUser_class()==null||"".equals(item.getUser_class()))&&(item.getUser_grade()==null||"".equals(item.getUser_grade()))){
                item = null;
            }
        }

        // 2.封装PageBean
        //获取当前页码
        String pageCodeStr = req.getParameter("page");
        // 一页显示的记录数
        String limit = req.getParameter("limit");
        //创建PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        int pageCode = 0;
        if(pageCodeStr != null){
            pageCode = Integer.parseInt(pageCodeStr);
        }else{
            System.out.println("转换异常");
        }
        pageBean.setPageCode(pageCode);
        int pageSize = 0;
        if(limit != null){
            pageSize = Integer.parseInt(limit);

        }
        pageBean.setPageSize(pageSize);
        pageBean.setOrder("user_id");
        pageBean.setSort("asc");
        //获取总记录数信息
        int total = userService.selectTotalByCondition(item);

        // 设置总记录数
        pageBean.setTotal(total);

        // 获取总页数
        int totalPage = 0;

        if(total%pageBean.getPageSize() > 0) {
            // 如果总记录数除以每页显示的记录数不能整除，就要总页码加1
            totalPage = total/pageBean.getPageSize() + 1;
        }else {
            totalPage = total/pageBean.getPageSize();
        }
        // 设置总页数
        pageBean.setTotalPage(totalPage);

        List<User> userList = null;

        userList = userService.selectCombination(pageBean,item);
        // 设置当前页的记录信息
        pageBean.setBeanList(userList);
        //将pageBean对象信息添加到request域中，转发回分页页面
        req.setAttribute("pageBean", pageBean);
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",userList);
        String s = gson.toJson(map);
        System.out.println("生成的JSON串："+s);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
        }

    /**
     * 添加用户信息
     * @param req
     * @param resp
     */
    public void addUser(HttpServletRequest req, HttpServletResponse resp) {
        String data = req.getParameter("data");
        System.out.println("data:" + data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        User user = gson.fromJson(data, User.class);
        logger.debug(user);
        PrintWriter writer = null;
        try{
            boolean flag = userService.insert(user);
            logger.debug(flag);
            writer = resp.getWriter();
            if(flag){
                writer.println(1);
            }else{
                writer.println(0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(writer != null){
                writer.close();
            }

        }

    }

    /**
     * 修改用户
     * @param req
     * @param resp
     */
    public void updateUser(HttpServletRequest req, HttpServletResponse resp) {
        String data = req.getParameter("data");
        logger.debug("data:"+data);
        Gson gson = new Gson();
        // 将JSON字符串转换成Java对象
        User user = gson.fromJson(data, User.class);
        logger.debug(user);
        User user1 = (User)req.getSession().getAttribute("user1");
        user.setUser_id(user1.getUser_id());
        PrintWriter writer = null;
        try {
            boolean flag = userService.update(user);
            logger.debug(flag);
            writer = resp.getWriter();
            if (flag) {
                logger.debug("用户修改成功");
                writer.println(1);
                //resp.sendRedirect(req.getContextPath()+"/page/User/selectUser.jsp");
            } else {
                logger.debug("用户修改失败");
                writer.println(0);
                //resp.sendRedirect("page/User/updateUser.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null){
                writer.close();
            }
        }
    }

    /**
     * 根据用户ID删除用户
     * @param req
     * @param resp
     */
    public void deleteByUser_id(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String user_id = req.getParameter("user_id");
        logger.debug("user_id="+user_id);
        if(user_id != null){
            int id = Integer.parseInt(user_id);
            boolean flag = userService.deleteById(id);
            if(flag){
                resp.getWriter().print(1);
            }else{
                resp.getWriter().print(0);
            }
        }else{
            logger.debug("user_id为空");
        }
    }

    /**
     * 根据用户ID查询用户
     * @param req
     * @param resp
     */
    public void selectByUser_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的用户的ID
        String user_id = req.getParameter("user_id");
        logger.debug("user_id="+user_id);
        int id = Integer.parseInt(user_id);
        User user = userService.selectByUser_id(id);
        req.getSession().setAttribute("user1",user);
        try {
            req.getRequestDispatcher("page/UserManage/updateUser.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查看用户详情
     * @param req
     * @param resp
     */
    private void selectDetailByUser_id(HttpServletRequest req, HttpServletResponse resp) {
        // 获取要修改的用户的ID
        String user_id = req.getParameter("user_id");
        logger.debug("user_id="+user_id);
        int id = Integer.parseInt(user_id);
        User user = userService.selectByUser_id(id);
        req.getSession().setAttribute("user2",user);
        try {
            req.getRequestDispatcher("page/UserManage/userDetail.jsp").forward(req,resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有用户
     * @param req
     * @param resp
     */
    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        IUserService userService = new UserServiceImpl();
        List<User> users = userService.selectAll();
        Map<String,Object> map = new LinkedHashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",1000);
        map.put("data",users);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
    }

    /**
     * 分页查询
     * @param req
     * @param resp
     */
    public void pageSelect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取当前页码
        String pageCodeStr = req.getParameter("page");
        // 一页显示的记录数
        String limit = req.getParameter("limit");
        //创建PageBean对象
        PageBean<User> pageBean = new PageBean<>();
        int pageCode = 0;
        if(pageCodeStr != null){
            pageCode = Integer.parseInt(pageCodeStr);
        }else{
            System.out.println("转换异常");
        }
        pageBean.setPageCode(pageCode);
        int pageSize = 0;
        if(limit != null){
            pageSize = Integer.parseInt(limit);

        }
        pageBean.setPageSize(pageSize);
        pageBean.setOrder("user_id");
        pageBean.setSort("desc");
        //获取总记录数信息
        int total = 0;

        total = userService.queryUserCount();

        // 设置总记录数
        pageBean.setTotal(total);


        // 获取总页数
        int totalPage = 0;

        if(total%pageBean.getPageSize() > 0) {
            // 如果总记录数除以每页显示的记录数不能整除，就要总页码加1
            totalPage = total/pageBean.getPageSize() + 1;
        }else {
            totalPage = total/pageBean.getPageSize();
        }
        // 设置总页数
        pageBean.setTotalPage(totalPage);

        List<User> userList = null;

        userList = userService.queryUserListLimit(pageBean);

        // 设置当前页的记录信息
        pageBean.setBeanList(userList);

        //将pageBean对象信息添加到request域中，转发回分页页面
        req.setAttribute("pageBean", pageBean);
       /* RequestDispatcher requestDispatcher = request.getRequestDispatcher("/userListLimit.jsp");
        requestDispatcher.forward(request, response);*/

        Map<String,Object> map = new LinkedHashMap<>();
        map.put("code",0);
        map.put("msg","");
        map.put("count",total);
        map.put("data",userList);
        Gson gson = new Gson();
        String s = gson.toJson(map);
        PrintWriter writer = resp.getWriter();
        writer.println(s);
        writer.close();
        }
    }





