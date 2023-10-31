onload = () => {
    $('#headerUsername').text($util.getItem('userInfo').username)
    $('#headerDivB').text('创建调查问卷')

    $('#startTime').datetimepicker({
        language: 'zh-CN', // 显示中文
        format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
        // minView: "month", // 设置只显示到月份
        minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
        minuteStep: 1,//分钟间隔1分钟
        initialDate: new Date(), // 初始化当前日期
        autoclose: true, // 选中自动关闭
        todayBtn: true // 显示今日按钮
    })
    $('#stopTime').datetimepicker({
        language: 'zh-CN', // 显示中文
        format: 'yyyy-mm-dd hh:mm:ss', // 显示格式
        // minView: "month", // 设置只显示到月份
        minView: 0,  //0表示可以选择小时、分钟   1只可以选择小时
        minuteStep: 1,//分钟间隔1分钟
        initialDate: new Date(), // 初始化当前日期
        autoclose: true, // 选中自动关闭
        todayBtn: true // 显示今日按钮
    })
    // let projectName = $util.getPageParam("projectName");
    // let questionnaireType= $util.getPageParam("questionnaireType");

}





const handleConfirm2 = () => {

    let surveyName = $('#surveyName').val();
    let surveyDescription = $('#surveyDescription').val();
    let startTime =  $('#startDate').val() && new Date($('#startDate').val()).getTime();
    let stopTime =  $('#stopDate').val() && new Date($('#stopDate').val()).getTime();
    let  currentTime=new Date();
    if (stopTime <= startTime) {
        alert("截止时间必须大于开始时间");
        return;
    }

    if (stopTime<= currentTime) {
        alert("结束时间必须大于当前时间");
        return;
    }


    let createNewQuestionnaire  = {
        projectId:$util.getPageParam('creatquestionnaire').projectId,
        projectName:$util.getPageParam('creatquestionnaire').projectName,
        questionnaireType:$util.getPageParam('creatquestionnaire').questionnaireType,
        questionnaireName: surveyName,
        questionnaireContent: surveyDescription,
        startTime: startTime,
        stopTime: stopTime
    };
    $util.setPageParam('createNewQuestionnaire', createNewQuestionnaire)
    let style = $("#style").val();
    let number=$('#answerCount').val();
    $util.setPageParam('countNumber',number);
    switch (style) {
        case "简约":
            location.href = "/pages/designQuestionnaire/index.html"
            break;
        case "华丽":
             location.href="/pages/designQuestionnaire/index1.html"
            break;

        default:
            break;
    }
    // location.href = "/pages/designQuestionnaire/index.html"


}



