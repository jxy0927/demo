onload = () => {
     let questionnaireName=$util.getPageParam('questionnaireName')
       $('#questionnaireName').text(questionnaireName)
    $('#problem').append(`
      <div class="question" id="question1" data-type="1" data-problemIndex="1">
        <div class="top">
          <span class="question-title" id="questionTitle">1.单选题</span>
          <span class="must-answer" id="mustAnswer">必答题</span>
        </div>
        <div class="bottom">
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
              <input type="radio" name="chooseTerm" checked="checked">选项1
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
              <input type="radio" name="chooseTerm">选项2
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
              <input type="radio" name="chooseTerm" }>选项3
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="radio-inline">
              <input type="radio" name="chooseTerm">选项4
            </label>
          </div>
        </div>
      </div>
    `)
    // <input type="radio" name="chooseTerm" checked = '${item.id}>选项3
    $('#problem').append(`
      <div class="question" id="question1" data-type="1" data-problemIndex="1">
        <div class="top">
          <span class="question-title" id="questionTitle">2.多选题</span>
          <span class="must-answer" id="mustAnswer">必答题</span>
        </div>
        <div class="bottom">
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="checkbox-inline">
              <input type="checkbox" name="chooseTerm">选项1
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="checkbox-inline">
              <input type="checkbox" name="chooseTerm">选项2
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="checkbox-inline">
              <input type="checkbox" name="chooseTerm">选项3
            </label>
          </div>
          <div style="display: flex; align-items: center; margin-bottom: 3px;">
            <label class="checkbox-inline">
              <input type="checkbox" name="chooseTerm">选项4
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
          <textarea class="form-control" placeholder="请输入" rows="4" style="width: 70%;"></textarea>
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
                <th>选项1</th>
                <th>选项2</th>
                <th>选项3</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>标题1</td>
                <td><input type="radio" name="chooseTerm1" /></td>
                <td><input type="radio" name="chooseTerm1" /></td>
                <td><input type="radio" name="chooseTerm1" /></td>
              </tr>
              <tr>
                <td>标题2</td>
                <td><input type="radio" name="chooseTerm2" /></td>
                <td><input type="radio" name="chooseTerm2" /></td>
                <td><input type="radio" name="chooseTerm2" /></td>
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
          <div>很满意</div>
          <div>
            <label class="radio-inline">
              <input type="radio" name="fraction" />5
            </label>
          </div>
          <div>
            <label class="radio-inline">
              <input type="radio" name="fraction" />4
            </label>
          </div>
          <div>
            <label class="radio-inline">
              <input type="radio" name="fraction" />3
            </label>
          </div>
          <div>
            <label class="radio-inline">
              <input type="radio" name="fraction" />2
            </label>
          </div>
          <div>
            <label class="radio-inline">
              <input type="radio" name="fraction" />1
            </label>
          </div>
          <div>很不满意</div>
        </div>
      </div>
    `)

}



const returnlast = () => {
       let getNumber = localStorage.getItem("Number")
    if (getNumber<0)
    {  alert('提交次数已用完！');}
    else {
        Number= getNumber - 1;
        $util.setPageParam('Number', Number);
        location.href = "/pages/seeProject/index.html?Number="
    }


}
