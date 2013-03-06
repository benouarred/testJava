describe('About objects : ', function(){

    it('type', function(){
        var result = {};
        expect(typeof(result)).toBe( _ );
    });

    it('literal notation', function(){
        var person = {_};
        expect(person.name).toBe('Jean Paul');
        expect(person.age).toBe(51);
    });

    it('dynamically adding properties', function(){
        var person = {};
        // _
        // _
        expect(person.name).toBe('Jean Paul');
        expect(person.age).toBe(51);
    });

    it('adding properties from strings', function(){
        var person = {};
        // _
        // _
        expect(person.name).toBe('Jean Paul');
        expect(person['phone-number']).toBe('0145254515');
    });

    it('adding functions', function(){
        var person = {
            name: "Jean Paul",
            age: 25,
            toString: function() {
                return _ ;
            }
        };
        expect(person.toString()).toBe('My name is Jean Paul and I am 25 years old');
    });


});
