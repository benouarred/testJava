describe('About truthyness : ', function(){

    it('of positive numbers', function(){
        var result;
        if(3){
            result = true;
        } else {
            result = false;
        }
        expect(result == _).toBeTruthy();
    });

    it('of negative numbers', function(){
        var result;
        if(-1){
            result = true;
        } else {
            result = false;
        }
        expect(result == _).toBeTruthy();
    });

    it('of zero', function(){
        var result;
        if(0){
            result = true;
        } else {
            result = false;
        }
        expect(result == _).toBeTruthy();
    });

    it('of null', function(){
        var result;
        if(null){
           result = true;
        } else {
            result = false;
        }
        expect(result == _).toBeTruthy();
    });

});