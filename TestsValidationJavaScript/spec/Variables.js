describe('About Variables : ', function(){

    it('assign a value to a variable in global scope', function(){
        nom = 'Thierry'
        expect(window._).toBe('Thierry');
    })

    it('assign a value to a local variable', function(){
        var age = 4;

        expect(age).toBe(_);
        expect(_.age).not.toBe(4);
    })

});