function formatDate(dateString) {
    let date = new Date(dateString);
    return date.toLocaleDateString() + ' ' + date.toLocaleTimeString();
}

function html(literals, ...vars) {
    let raw = literals.raw,
        result = '',
        i = 1,
        len = arguments.length,
        str,
        variable

    while (i < len) {
        str = raw[i - 1]
        variable = vars[i -1]
        result += str + variable
        i++
    }
    result += raw[raw.length - 1]
    return result
}

function render(data, template) {
    if (!template) return
    if (typeof data === 'string') {
        // Handle primitive type:
        return template(data)
    } else if (typeof data === 'object' && !Array.isArray(data)) {
        // Handle object:
        return template(data)
    } else if (Array.isArray(data)) {
        // Handle array:
        return data.map(item => template(item)).join('')
    }
}
