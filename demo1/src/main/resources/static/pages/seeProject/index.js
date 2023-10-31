onload = () => {
  $('#headerDivB').text('项目详情')
  let projectId = $util.getPageParam('seeProject')
  console.log(projectId, 'projectId')
  fetchProjectInfo(projectId)
  fetchQuestionnaireList()


}
let questionnaireList=[]
const fetchQuestionnaireList = () => {
  let params = {
    // createdBy: $util.getItem('userInfo').username,
    // projectName: $('#projectName').val()
    projectId: $util.getPageParam('seeProject')
  }

  $.ajax({
    url: API_BASE_URL + '/queryQuestionnairetListByProjectId',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      questionnaireList = res.data
      $('#questionnaireList').html('')

      res.data.map((item, index) => {
        $('#table #tbody').append(`
          <tr>
            <td>${index + 1}</td>
            <td>${item.questionnaireName}</td>
            <td>${item.startTime}</td>
            
            <td>
              <button id="generateLinkButton" type="button" class="btn btn-link" onclick="joinAnswerSheet('${item.questionnaireName}')">预览</button>
              <button type="button" class="btn btn-link" onclick="publish('${item.questionnaireName}')">发布</button>
              <button type="button" class="btn btn-link btn-red" onclick="deleteQuestionnaire('${item.id}')">删除</button>
              
            </td>
          </tr>
        `)
      })

    }
  })
}

const publish = (name) => {
  let generateLinkButton = document.getElementById("generateLinkButton");
  generateLinkButton.addEventListener("click", generateLink());
  function generateLink() {
    let questionnaireName=name
    let link = "http://127.0.0.1:8085/pages/answerSheet/index1.html"+"?"+ +questionnaireName ; // 生成的链接
    alert('可通过以下网址进入答卷 : '+link)
    // window.location.href = link; // 设置当前页面的链接
  }

}

const joinAnswerSheet = (questionnaireName,flag) => {
  // $util.setPageParam('answerSheet',  )
  // location.href = '/pages/answerSheet/index1.html'

  const number = $util.getPageParam('Number');
  localStorage.setItem('Number', number);
  console.log('22'+number)
  // if (number < 0) {
  //   alert('提交次数已用完！');
  // } else {
    $util.setPageParam('questionnaireName', questionnaireName);
    //localStorage.setItem('questionnaireName', questionnaireName);
    // 修改页面跳转地址
    location.href = '/pages/answerSheet/index1.html';

    // 更新number的值
    // const updatedNumber = number - 1;
    // $util.setPageParam('Number', updatedNumber);
  //}
}

const deleteQuestionnaire = (pid) => {
  let state = confirm("确认删除该项目吗？")

  if (state) {
    let params = {
      id:pid
    }

    // alert(params.id)

    //alert(JSON.stringify(params))
    $.ajax({
      url: API_BASE_URL + '/deleteQuestionnaireById',
      type: "POST",
      data: JSON.stringify(params),
      dataType: "json",
      contentType: "application/json",
      success(res) {
        alert(res.message)
        location.href = '/pages/seeProject/index.html'
      }
    })
  }

}

const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info = res.data.find(project => project.id === id)
      //let info = res.data[0]
      console.log(info, 'res')
      $('#projectName').text(info.projectName)
      $('#createTime').text(info.creationDate)
      $('#createdBy').text(info.createdBy)
      $('#projectDescription').text(info.projectContent)
    }
  })
}