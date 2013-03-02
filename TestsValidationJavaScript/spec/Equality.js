describe('About equality : ', function(){

    it('for number', function(){
        expect(3 + _).toBe(7);
    });

    it('for string', function(){
        expect("3" + _).toBe("37");
    });

    it('on value', function(){
        expect(8 _ '8').toBeTruthy();
    });

    it('on type and value', function(){
        expect(8 _ '8').toBeFalsy();
    });

    it('on string literals', function(){
        expect("hello" _ 'hello').toBeTruthy();
    });

});