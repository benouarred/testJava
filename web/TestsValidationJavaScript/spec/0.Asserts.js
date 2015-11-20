describe('About Jasmine assertions : ', function(){

    it('you should know what will satisfy the toBeTruthy assertion', function(){
       expect( true ).toBeTruthy();
    });

    it('you should know what will satisfy the toBeFalsy assertion', function(){
        expect( false ).toBeFalsy();
    });

    it('you should know what will satisfy the toBe assertion', function(){
        expect('3').toBe('3');
    });

    it('you should know what will satisfy the not assertion', function(){
        expect(45).not.toBe('3');
    });

})