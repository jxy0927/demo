// window.onload = function() {
//     var table = document.getElementById("myTable");
//
//     // 添加行和单元格
//     var row = table.insertRow();
//     var cell1 = row.insertCell();
//     var cell2 = row.insertCell();
//     var cell3 = row.insertCell();
//     var cell4 = row.insertCell();
//
//     // 设置单元格内容
//     cell1.innerHTML = "值---------------------------------1";
//     cell2.innerHTML = "值2";
//     cell3.innerHTML = "值3";
//     cell4.innerHTML = "值4";
// };


onload = () => {
    // alert('加载成功')
    // alert($util.getPageParam('showQuestionnaireWrited'))
    // $('#headerUsername').text($util.getItem('userInfo').username)
    // $('#headerDivB').text('用户管理')
    fetchRespQuestionnaireList();
}
let respQuestionnaireList=[]
const fetchRespQuestionnaireList = () => {
    let params = {
        projectId: $util.getPageParam('showQuestionnaireWrited')
    }
    // alert('1111'+params.projectId)
    $.ajax({
        url: API_BASE_URL + '/selectRespondedQuestionnaire',
        type: 'POST',
        data: JSON.stringify(params),
        dataType: 'json',
        contentType: 'application/json',
        success(res) {
            // alert("用户列表")
            $('#table #tbody').html('')
            respQuestionnaireList = res.data
            res.data.map((item, index) => {
                $('#table #tbody').append(`
          <tr>
            <td>${item.questionnaireName}</td>
            <td>${item.respondent}</td>
            <td>${item.time}</td>
            <td>
                <button type="button" class="btn btn-link btn-red" onclick="joinAnswerSheet('${item.problemId}', '${item.questionnaireName}')">明细</button> 
            </td>
          </tr>
        `)
            })


        }
    })

}
const joinAnswerSheet = (id,questionnaireName) => {
   $util.setPageParam('questionnaireName',questionnaireName)
    $util.setPageParam('answerSheet',id)
    location.href = '/pages/answerSheet/index.html'

}

const selectRespondent = () => {

    let params = {
        respondent: $('#projectName').val()
    }
    alert('-------'+params.respondent)
    // if (!params.projectName) fetchProjectList()

    $.ajax({
        url: API_BASE_URL + '/selectRespondedQuestionnaireByName',
        type: "POST",
        data: JSON.stringify(params),
        dataType: "json",
        contentType: "application/json",
        success(res) {
            // alert("用户列表")
            $('#table #tbody').html('')
            respQuestionnaireList = res.data
            res.data.map((item, index) => {
                $('#table #tbody').append(`
          <tr>
            <td>${item.questionnaireName}</td>
            <td>${item.respondent}</td>
            <td>${item.time}</td>
            <td>
              <button type="button" class="btn btn-link btn-red" onclick="joinAnswerSheet('${item.problemId}')">明细</button>
            </td>
          </tr>
        `)
            })
        }
    })

}

