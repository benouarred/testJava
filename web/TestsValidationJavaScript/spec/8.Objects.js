describe('Objects', function(){

    it('Objects - 1', function(){
        var result = {};
        expect(typeof(result)).toBe( 'object' );
    });

    it('Objects - 2', function(){
        var person = {
            name:'Jean Paul', age:51
        };
        expect(person.name).toBe('Jean Paul');
        expect(person.age).toBe(51);
    });

    it('Objects - 3', function(){
        var person = {};
        person.name = 'Jean Paul';
        person.age = 51;

        expect(person.name).toBe('Jean Paul');
        expect(person.age).toBe(51);
    });

    it('Objects - 4', function(){
        var person = {};
        person.name = 'Jean Paul';
        person['phone-number'] = '0145254515';
        expect(person.name).toBe('Jean Paul');
        expect(person['phone-number']).toBe('0145254515');
    });

    it('Objects - 5', function(){
        var person = {
            name: "Jean Paul",
            age: 25,
            toString: function() {
                return 'My name is '+ this.name + ' and I am ' + this.age + ' years old' ;
            }
        };
        expect(person.toString()).toBe('My name is Jean Paul and I am 25 years old');
    });


});
