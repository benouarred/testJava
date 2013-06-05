describe('About Jasmine assertions : ', function(){

    it('you should know what will satisfy the toBeTruthy assertion', function(){
       expect( _ ).toBeTruthy();
    });

    it('you should know what will satisfy the toBeFalsy assertion', function(){
        expect( _ ).toBeFalsy();
    });

    it('you should know what will satisfy the toBe assertion', function(){
        expect( _ ).toBe('3');
    });

    it('you should know what will satisfy the not assertion', function(){
        expect( _ ).not.toBe('3');
    });

})