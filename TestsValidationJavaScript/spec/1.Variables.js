describe('About Variables : ', function(){

    nom = "Pierre";

    it('assign a value to a variable in global scope', function(){
        // _
        expect(nom).toBe('Thierry');
        expect(window.nom).toBe('Thierry');
    })

    age = 6;

    it('assign a value to a local variable', function(){
        // _
        expect(age).toBe(4);
        expect(window.age).toBe(6);
    })

});