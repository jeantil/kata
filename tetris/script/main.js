var game={
  pixels:0,h:0,w:0,score:0,lines:0,level:0,stop:false,shape:'',next:'',
  
  init:function(height, width){
    var p = new Array(), line = '';
    for ( x=0; x<= width ; x++ ) line+='0';
    for ( y=0; y<= height; y++ ) p[y]=line;
    this.h = height;
    this.w = width;
    this.pixels=p;
    game.insert();
  },
  
  draw:function(){
    var p = Processing( $('#cv')[0] );
    //p.size(game.w*45,game.h*42)
    p.size(game.w*20+8,game.h*20+6)
    for ( y=0; y<game.h; y++ ) {
      for ( x=0; x<game.w; x++ ) {
        if ( game.exist(x,y) ) {
          if (game.pixels[y][x]=='3') {
            p.fill('grey');
          } else if (block.z.toString() === game.shape.toString()){
            p.fill('blue');
          } else if (
            block.s.toString() === game.shape.toString()){
            p.fill('rgb(200,0,0)');
          } else if (
            block.j.toString() === game.shape.toString()){
            p.fill('maroon');
          } else if (
            block.l.toString() === game.shape.toString()){
            p.fill('yellow');
          } else if (
            block.t.toString() === game.shape.toString()){
            p.fill('green');
          } else if (
            block.o.toString() === game.shape.toString()){
            p.fill('pink');
          }           
          
          
        } else {
          p.fill('black');
        }
        //p.ellipse((x+1)*40,(y+1)*40,38,38);
        p.rect(x*20+5,y*20+5,18,18);
        p.fill('black');
        p.rect(x*20+10,y*20+10,8,8);
      }
    }
  },
  
  
  drawnext:function(){
    var p = Processing( $('#nxt')[0] );
    p.size(80,40);
    var b = game.next.toString();
    for ( y=0; y<2; y++ ) {
      for ( x=0; x<4; x++ ) {
        p.fill('black');
        p.rect(x*20,y*20,18,18);
      }
    }
    for ( y=0; y<2; y++ ) {
      if ( game.next[y] ) {
        for ( x=0; x<game.next[y].length; x++ ) {
          if ( game.next[y][x] !== '0' ) {
            if (block.z.toString() === b){ p.fill('blue');
            } else if (block.s.toString() === b){p.fill('rgb(200,0,0)');
            } else if (block.j.toString() === b){p.fill('maroon');
            } else if (block.l.toString() === b){p.fill('yellow');
            } else if (block.t.toString() === b){p.fill('green');
            } else if (block.o.toString() === b){p.fill('pink');
            }
            p.rect(x*20,y*20,18,18);
            p.fill('black');
            p.rect(x*20+5,y*20+5,8,8);           
          } else {
            p.fill('black');
            p.rect(x*20,y*20,18,18);
          }
        }
      }
    }
  },
  
  move:function(direction){
    
    var result=new Array();
      
    if      ( 'down' == direction ) result=game.down();
    else if ( 'right'== direction ) result=game.right();
    else if ( 'left' == direction ) result=game.left();
      
    if (!game.stop && !game.bang(result)) {
        game.pixels=game.deadoverlay(result);
    } else if ( 'down' == direction ) {
      game.freeze();
      var pt = game.clean();
      game.bonus(pt);
      game.insert();
      game.stop=false;
    }
    game.draw();
  },
  
  left:function(){
    var result=new Array(), canmove=true;
    
    //check if there is an active block on the far left
    for (var y=0; y<game.h; y++ ) 
      if (game.on(0,y)) canmove=false;
    
    if (canmove) {
      for ( y=0; y< game.h ; y++ ){
        var line='',px='';
        for ( x=0; x<game.w-1; x++ ){
          px=game.pixels[y][x+1];
          if (px != '3') line+=px;
          else line+='0';
        }
        px=game.pixels[y][0];
        if (px != '3') line+=px;
        else line+='0';
        result[y]=line;
      }
    } else {
      result=game.pixels;
    }
    return result;
  },

  right:function(){
    var result=new Array();
    var canmove=true;
    
    //check if there is an active block on the far right
    for (var y=0; y<game.h; y++ ) 
      if (game.on(game.w-1,y)) canmove=false;
    
    if (canmove) {
      for ( y=0; y<game.h ; y++ ){
        var line = '',px='';
        for ( x=0; x< game.w ; x++ ){
          if ( x==0 ) px=game.pixels[y][game.w-1];
          else px=game.pixels[y][x-1];
          if (px != '3') line+=px;
          else line+='0';
        }
        result[y]=line;
      }
    } else {
      result=game.pixels;
    }
    return result;
  },
  
  bonus:function(pt){
    if      (pt==1) game.score+=1;
    else if (pt==2) game.score+=5;
    else if (pt==3) game.score+=10;
    else if (pt==4) game.score+=20;
    game.lines+=pt;
    $('#lines')[0].innerText=game.lines;
    game.level=Math.floor(game.lines/10);
    
    $('#level')[0].innerText=game.level;
    $('#score')[0].innerText=game.score;
  },
  
  down:function(){
    if (game.stuck()) game.stop=true;
    var result=new Array();
    var blank='';
    for ( y=0; y<game.h; y++ ) blank=blank+'0';
    result[0]=blank;
    for ( y=1; y<game.h; y++ ) {
      if (!game.stop){
        var topline=game.pixels[y-1],
            line='';
        for ( x=0; x<topline.length; x++ ){
          if ( topline[x] =='3' ) line=line+'0';
          else line=line+topline[x];
        }
        result[y]=line;
      }
    }
    return result;
  },
  
  deadoverlay:function(result){
    for ( y=0; y<game.h; y++ ) {
      for ( x=0; x<game.w; x++ ) {
        if ( game.pixels[y][x]=='3' ) {
          game.inject(result,x,y,'3');
        }
      }
    }
    return result;
  },
  
  bang:function(result){
    var poc=false;
    for ( y=0; y<game.h; y++ ) {
      for ( x=0; x<game.w; x++ ) {
        if ( game.pixels[y][x]=='3' 
             &&   result[y][x]=='1' ){
          poc=true;
          console.log('bang');
        }
      }
    }
    return poc;
  },
  
  //scan each column, check if there is space left
  stuck:function(){
    var stop=false;
    for (var x=0; x<game.w; x++ ) { //column : x !
      var blockbottom=0;
      var deadtop=game.h; // if there are no dead block, use bottom
      for ( y=0; y<game.h; y++ ) {
        var px=game.pixels[y][x];
        if (px=='1'||px=='2') blockbottom=y;
        else if (px=='3' && deadtop > y) deadtop=y;
      }
      
      // if there is a block in this row
      if (blockbottom != 0 && 
         (deadtop-blockbottom ==1 || 
          game.h-blockbottom ==1)) {
        stop=true;
      }
      
    }
    return stop;
  },
  
  freeze:function(){
    var result=new Array();
    for ( y=0; y<game.h; y++ ) {
      for ( x=0; x<game.w; x++ ) {
        if ( game.on(x,y) ) {
          game.inject(game.pixels,x,y,'3');
        }
      }
    }
  },
  
  clean:function(){
    var nblines=0;
    for ( y=0; y<game.h; y++ ) {
      var deadinrow=0;
      for ( x=0; x<game.w; x++ ) {
        if ( game.pixels[y][x]=='3' ) deadinrow++;
      }
      if (deadinrow==game.w) {
        var z=y;
        nblines++;
        var copy = game.pixels.slice(0);
        for ( var z=1; z<=y;z++) {
          game.pixels[z]=copy[z-1];
        }
      }
    }
    return nblines;
  },

  cleandead:function(result){
    for ( y=0; y<game.h; y++ ) {
      for ( x=0; x<game.w; x++ ) {
        if ( result[y][x]=='3' ) {
          game.inject(result,x,y,'0');
        }
      }
    }
    return result;
  },
  
  rotate:function(clock){
    
    var result=new Array();
    var outside=false;
    result=game.empty();
    game.findpivot();
    game.inject(result,r.x,r.y,'2');
        
    for ( y=0; y < game.h ; y++ ){
      for ( x=0; x < game.w ; x++ ){
        if ( game.on(x,y) ) {
          var newx=666;
          var newy=666;
          if ( clock && !outside ){
            if      ( x+2==r.x && y==r.y){newx=x+2;newy=y-2;}//l
            else if ( x==r.x && y+2==r.y){newx=x+2;newy=y+2;}//l
            else if ( x-2==r.x && y==r.y){newx=x-2;newy=y+2;}//l
            else if ( x==r.x && y-2==r.y){newx=x-2;newy=y-2;}//l
            else if ( x< r.x && y< r.y ) {newx=x+2;newy=y  ;}//top left
            else if ( x==r.x && y< r.y ) {newx=x+1;newy=y+1;}//top
            else if ( x> r.x && y< r.y ) {newx=x  ;newy=y+2;}//top right
            else if ( x< r.x && y==r.y ) {newx=x+1;newy=y-1;}//left
            else if ( x> r.x && y==r.y ) {newx=x-1;newy=y+1;}//right
            else if ( x< r.x && y> r.y ) {newx=x  ;newy=y-2;}//bottom left
            else if ( x==r.x && y> r.y ) {newx=x-1;newy=y-1;}//bottom
            else if ( x> r.x && y> r.y ) {newx=x-2;newy=y  ;}//bottom right
          } else if ( !outside ){
            if      ( x+2==r.x && y==r.y){newx=x+2;newy=y+2;}//l
            else if ( x==r.x && y+2==r.y){newx=x-2;newy=y+2;}//l
            else if ( x-2==r.x && y==r.y){newx=x-2;newy=y-2;}//l
            else if ( x==r.x && y-2==r.y){newx=x+2;newy=y-2;}//l
            else if ( x< r.x && y< r.y ) {newx=x  ;newy=y+2;}//top left
            else if ( x==r.x && y< r.y ) {newx=x-1;newy=y+1;}//top
            else if ( x> r.x && y< r.y ) {newx=x-2;newy=y  ;}//top right
            else if ( x< r.x && y==r.y ) {newx=x+1;newy=y+1;}//left
            else if ( x> r.x && y==r.y ) {newx=x-1;newy=y-1;}//right
            else if ( x< r.x && y> r.y ) {newx=x+2;newy=y  ;}//bottom left
            else if ( x==r.x && y> r.y ) {newx=x+1;newy=y-1;}//bottom
            else if ( x> r.x && y> r.y ) {newx=x  ;newy=y-2;}//bottom right
          }
          if (newx!=666 && newy!=666) {
            if (newx>=game.w || newx <0 || newy <0 ) {
              outside=true;
              console.log('outside');
            } else {
              game.inject(result,newx,newy,'1');
            }
          }
        }
      }
    }
    result=game.cleandead(result);
    if ( !game.bang(result) && !outside ) {
      game.pixels=game.deadoverlay(result);
    }
    var result=new Array();
    game.draw();
  },
  
  inject:function(grid,x,y,px){
    var line = grid[y],
        before='',
        after ='';
    if (line.substring(0,x)       ) before = line.substring(0,x);
    if (line.substring(x+1,game.w)) after  = line.substring(x+1,game.w);
    line = before+px+after;
    grid[y]=line;
  },
  
  findpivot:function(){
    r = {x:0,y:0};
    for ( y=0; y<(game.h); y++ ) {
      for ( x=0; x<(game.w); x++ ) {
        if ( game.pixels[y][x] == '2') {
          r.x=x;
          r.y=y;
        }
      }
    }
  },
  
  exist:function(x,y){
    return ( game.pixels[y][x] != '0' );
  },
  
  on:function(x,y){
    var px = game.pixels[y][x];
    return ( px == '1' || px == '2' );
  },
  
  empty:function(){
    var g=new Array();
    for ( y=0; y < game.h ; y++ ){
      var line='';
      for ( x=0; x < game.w ; x++ ){
        line=line+'0';
      }
      g[y]=line;
    }
    return g;
  },
  
  randomblock:function(){
    var i =Math.floor(Math.random()*6);
    var blk;
    if      (i==0) blk=block.z;
    else if (i==1) blk=block.s;
    else if (i==2) blk=block.j;
    else if (i==3) blk=block.l;
    else if (i==4) blk=block.t;
    else if (i==5) blk=block.o;
    return blk;
  },
  
  drawpixel:function(color){
    var context=$('#cv')[0].getContext('2d');
    context.fillStyle='rgb(200,20,200)';
    context.fillRect(10,10,20,20);
  },
    
  insert:function(){
    
    //var s=game.randomblock();//shape
    if (game.next === '') game.next=game.randomblock();
    
    var s=game.next.slice(0);
    game.shape=s;
    game.next=game.randomblock();
    //$('#next')[0].innerText=game.next;
    game.drawnext();

    var start='',end='',
        l = Math.floor((game.w-s[0].length)/2),
        r = game.w-s[0].length-l;

    for ( x=0; x<l; x++ ) start+='0';
    for ( x=0; x<r; x++ ) end  +='0';
    
    var gameover = false;
    for ( var x=l; x<l+r; x++ ) {
      if ( game.pixels[0][x] != '0' ||
           game.pixels[1][x] != '0' ) {
           gameover=true;
      }
    } 
    
    if (!gameover) {
      if (s[0]) game.pixels[0]=start+s[0]+end;
      if (s[1]) game.pixels[1]=start+s[1]+end;
      game.draw();
    } else {
      $('#play')[0].value = "game over";
    }
  }
}

$(document).ready(function(){
  //tdd();
  var height=18, width =10;
  game.init(height,width);
  game.draw();
  $(document).click(function(){clickHandler();});
  $(document).bind('keypress', function(e) {
    var k=e.keyCode;
    if     (k==115) game.move('down');//s
    else if(k==113) game.move('left');//q
    else if(k==100) game.move('right');//d
    else if(k==106) game.rotate(true);//j
    else if(k==107) game.rotate(false);//k
  });
});

var block={
  z:['110','021'],
  s:['011','120'],
  j:['121','100'],
  j:['100','121'],
  t:['010','121'],
  l:['1211'],
  o:['12','11']
};

var interval = 0;

function clickHandler (){
  var play = $('#play')[0].value;
  if ( play == "start" ) {
    $('#play')[0].value = "stop";
    interval = setInterval ( "game.move('down');", 1000 );
  } else {
    $('#play')[0].value = "start";
    clearInterval ( interval );
  }
}
