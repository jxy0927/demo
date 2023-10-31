onload = () => {
  joinWritedQuestion()
  let questionnaireName=$util.getPageParam('questionnaireName')
  $('#questionnaireName').text(questionnaireName)
}


let questionBank=[]

const joinWritedQuestion = () => {

  let params = {
    problemId: $util.getPageParam('answerSheet')

  }



// alert('进入--------'+params.problemId)
  $.ajax({
    url: API_BASE_URL + '/queryQuestionList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      projectList = res.data

      let t1=[]
      let tb=[]

      let t2=[]
      let tbb=[]

      let t3=''

      let t4title=[]
      let t44=[]
      let t441=[]

      let t5title=[]
      let t55=[]
      let t5content=[]
      res.data.map((item,index) => {
        if(item.questionNumber=='1'){
          t1.push(item.answerContent)
          if(item.status=='1'){
            tb[t1.length-1]='checked="checked"'
          }
        }

        if(item.questionNumber=='2'){
          t2.push(item.answerContent)
          if(item.status=='1'){
            tbb[t2.length-1]='checked="checked"'
          }
        }

        if(item.questionNumber=='3'){
          t3=item.answerContent
        }

        if(item.questionNumber=='4'){
          let tt4=item.answerContent.split("-")
          t4title[0]=tt4[0]
          t4title[1]=tt4[1]
          t4title[2]=tt4[2]

          t44.push(tt4[3])

          t441[item.status]='checked="checked"'
        }

        if(item.questionNumber=='5'){
          let tt4=item.answerContent.split("-")
          t5title[0]=tt4[0]
          t5title[1]=tt4[1]

          t5content[0]=tt4[2]
          t5content[1]=tt4[3]
          t5content[2]=tt4[4]
          t5content[3]=tt4[5]
          t5content[4]=tt4[6]

          t55[item.status]='checked="checked"'
        }

      })


      $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">1.单选题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm" ${tb[0]}>${t1[0]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm" ${tb[1]}>${t1[1]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm" ${tb[2]}>${t1[2]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="radio-inline">
            <input type="radio" name="chooseTerm" ${tb[3]}>${t1[3]}
          </label>
        </div>
        
      </div>
    </div>
  `)

      $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">2.多选题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm" ${tbb[0]}>${t2[0]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm" ${tbb[1]}>${t2[1]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm"${tbb[2]}>${t2[2]}
          </label>
        </div>
        <div style="display: flex; align-items: center; margin-bottom: 3px;">
          <label class="checkbox-inline">
            <input type="checkbox" name="chooseTerm" ${tbb[3]}>${t2[3]}
          </label>
        </div>
      </div>
    </div>
  `)

      $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">3.填空题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;">${t3}</textarea>
    </div>
  `)

      $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">4.矩阵题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom">
        <table class="table">
          <thead>
            <tr>
              <th></th>
              <th>${t4title[0]}</th>
              <th>${t4title[1]}</th>
              <th>${t4title[2]}</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${t44[0]}</td>
              <td><input type="radio" name="chooseTerm1" ${t441[0]}/></td>
              <td><input type="radio" name="chooseTerm1" ${t441[1]}/></td>
              <td><input type="radio" name="chooseTerm1" ${t441[2]}/></td>
            </tr>
            <tr>
              <td>${t44[1]}</td>
              <td><input type="radio" name="chooseTerm2" ${t441[3]}/></td>
              <td><input type="radio" name="chooseTerm2" ${t441[4]}/></td>
              <td><input type="radio" name="chooseTerm2" ${t441[5]}/></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  `)

      $('#problem').append(`
    <div class="question" id="question1" data-type="1" data-problemIndex="1">
      <div class="top">
        <span class="question-title" id="questionTitle">5.量表题</span>
        <span class="must-answer" id="mustAnswer">必答题</span>
      </div>
      <div class="bottom" style="display: flex; align-items: center; justify-content: space-between;">
        <div>${t5title[0]}</div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" ${t55[0]}/>${t5content[0]}
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" ${t55[1]}/>${t5content[1]}
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" ${t55[2]}/>${t5content[2]}
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" ${t55[3]}/>${t5content[3]}
          </label>
        </div>
        <div>
          <label class="radio-inline">
            <input type="radio" name="fraction" ${t55[4]}/>${t5content[4]}
          </label>
        </div>
        <div>${t5title[1]}</div>
      </div>
    </div>
  `)












    }
  })

}
// const handleConfirm2 = () => {
// const fileInput = document.createElement('input');
// fileInput.type = 'file';
//
// fileInput.addEventListener('change', (event) => {
//   const file = event.target.files[0];
//   const reader = new FileReader();
//
//   reader.onload = (e) => {
//     const json = e.target.result;
//     const html = convertJsonToHtml(json);
//     const problemDiv = document.getElementById('problem');
//     problemDiv.innerHTML = html;
//   };
//
//   reader.readAsText(file);
// });
//
// fileInput.click();
//   const convertJsonToHtml = (json) => {}
// }


