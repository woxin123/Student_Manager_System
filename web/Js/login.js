function reload() {
    var time = new Date().getTime();
    document.getElementById("verification").scr = "<%= request.getContextPath()%>/ImageServlet?d=" + time;
}