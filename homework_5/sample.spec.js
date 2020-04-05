describe('task todo', function () {
    let page;

    before (async function () {
      page = await browser.newPage();
      await page.goto('http://127.0.0.1:7001');
    });
  
    after (async function () {
      await page.close();
    });


    it('should new todo correct', async function() {
      await page.click('#new-todo', {delay: 500});
      await page.type('#new-todo', 'new todo item', {delay: 50});
      await page.keyboard.press("Enter");
      let todoList = await page.waitFor('#todo-list');
      const expectInputContent = await page.evaluate(todoList => todoList.lastChild.querySelector('label').textContent, todoList);
      expect(expectInputContent).to.eql('new todo item');
    }) 

    it('should clicked correct', async function() {
      page.evaluate(() => {
        let elements = document.getElementsByClassName('toggle');
        elements[elements.length - 1].click();
        console.log(elements.length - 1);
      });
    })

    it('should done todo correct', async function() {
      let todoList = await page.waitFor('#todo-list');
      const expectStatus = await page.evaluate(todoList => todoList.lastChild.querySelector('input').checked, todoList);
      expect(expectStatus).to.eql(true);
    })

    it('should show todo correct', async function() {
      const todoListLength = await page.evaluate(() => {
          return document.getElementsByClassName('view').length;
      });
      const doneListLength = await page.evaluate(() => {
          return document.getElementsByClassName('completed').length;
      });
      let todoCount = await page.waitFor('#todo-count');
      const count = await page.evaluate(todoCount => todoCount.querySelector('strong').textContent, todoCount)
      expect(todoListLength - doneListLength).to.eql(+count);
  })
});