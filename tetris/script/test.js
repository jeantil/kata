function tdd(){
  test("Tetris",function(){
    ok(true)
    game.init([])
    game.draw()
  })

  test("Move",function(){
    game.move()

    game.init([
      '000',
      '010',
      '000']);
    game.move('down');
    same(game.pixels,['000','000','010'])
    
    game.init(['000','010','000']);
    game.move('up');
    same(game.pixels,['010','000','000'])

    game.init(['000','010','000']);
    game.move('right');
    same(game.pixels,['000','001','000'])

    game.init(['000','010','000']);
    game.move('left');
    same(game.pixels,['000','100','000'])

  })
/*
  test("Cross borders",function(){
    game.infinite=true;
    game.init(['000','001','000']);
    game.move('right');
    same(game.pixels,['000','100','000'])

    game.init(['000','100','000']);
    game.move('left');
    same(game.pixels,['000','001','000'])

    game.init(['010','000','000']);
    game.move('up');
    same(game.pixels,['000','000','010'])

    game.init(['000','000','010']);
    game.move('down');
    same(game.pixels,['010','000','000'])
  })
  
*/
  test("Insert blocks",function(){
    game.init(['000','000','000']);
    game.insert('s');
    same(game.pixels,['011',
                      '120','000']);
  })
  
  
  test("Rotate blocks",function(){
    game.init(['000','000','000']);
    game.insert('s');
    
    game.findpivot();
    same([1,1],[r.x,r.y]);
    
    game.rotate(true);
    same(game.pixels,['010',
                      '021',
                      '001']);
                      
    game.rotate(false);
    same(game.pixels,['011',
                      '120',
                      '000']);
  })
  
  
  test("Freeze",function(){
    game.init(['000','011','120']);
    game.freeze();
    same(game.pixels,['000','033','330']);
  })
}
